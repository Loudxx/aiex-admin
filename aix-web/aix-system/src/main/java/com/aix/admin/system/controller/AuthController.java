package com.aix.admin.system.controller;

import cn.hutool.core.util.ObjectUtil;
import com.aix.admin.system.dto.LoginDTO;
import com.aix.admin.system.dto.MenuDTO;
import com.aix.admin.system.entity.UserDO;
import com.aix.admin.system.service.LoginService;
import com.aix.admin.system.service.MenuService;
import com.aix.framework.core.base.Result;
import com.aix.framework.core.enums.ErrorCodeEnum;
import com.aix.framework.web.exception.BizException;
import com.aix.framework.web.redis.RedisCache;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Value("${aix.security.captcha.enabled}")
    private Boolean captchaEnable;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private LoginService loginService;

    @Autowired
    private MenuService menuService;

    /**
     * 测试
     * @return String
     */
    @GetMapping("/test")
    public String test(){
        return "123";
    }

    /**
     * 验证码
     * @return Map<String, Object>
     */
    @GetMapping("/captcha")
    public Result<Map<String, Object>> captcha(){
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String uuid = UUID.randomUUID().toString();
        // 存入redis并设置过期时间为30分钟
        redisCache.setCacheObject(uuid, verCode, 30, TimeUnit.MINUTES);
        // 将key和base64返回给前端
        Map<String, Object> map = new HashMap<>(2);
        map.put("uuid", uuid);
        map.put("image", specCaptcha.toBase64());
        return Result.ok(map);
    }

    /**
     * 登录
     * @param loginDTO 登录信息
     * @return Map<String, Object>
     */
    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody LoginDTO loginDTO){
        if(captchaEnable){
            String localCaptcha = redisCache.getCacheObject(loginDTO.getUuid());
            // 校验验证码
            BizException.isTrue(ObjectUtil.equal(localCaptcha, loginDTO.getCode()), ErrorCodeEnum.FAIL);
        }
        // 登录生成token
        String token = loginService.login(loginDTO);
        Map<String, Object> map = new HashMap<>(1);
        map.put("accessToken", token);
        return Result.ok(map);
    }


    /**
     * 获取当前登录用户信息
     * @return User
     */
    @GetMapping("/getUserMenu")
    public Result<List<MenuDTO>> getUserMenu(){
        UserDO user = (UserDO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<MenuDTO> menuDTOList;
        if(user.isAdmin()){
            menuDTOList = menuService.selectAllTree();
        }else{
            menuDTOList = menuService.listTreeByUserId(user.getId());
        }
        return Result.ok(menuDTOList);
    }

    /**
     * 获取当前登录用户信息
     * @return User
     */
    @GetMapping("/getUserInfo")
    public Result<UserDO> getUserInfo(){
        UserDO user = (UserDO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Result.ok(user);
    }

    /**
     * 获取权限码
     * @return Void
     */
    @GetMapping("/codes")
    public Result<Void> codes(){
        return Result.ok();
    }

    /**
     * 刷新token
     * @return Void
     */
    @PostMapping("/refresh")
    public Result<Void> refresh(){
        return Result.ok();
    }

    /**
     * 退出登录
     * @return Void
     */
    @PostMapping("/logout")
    public Result<Void> logout(){
        return Result.ok();
    }




}
