package com.aiex.admin.system.controller;

import cn.hutool.core.util.ObjectUtil;
import com.aiex.admin.system.dto.LoginDTO;
import com.aiex.admin.system.dto.MenuDTO;
import com.aiex.admin.system.dto.UserAuthDTO;
import com.aiex.admin.system.dto.UserDTO;
import com.aiex.admin.system.dto.query.MenuQueryDTO;
import com.aiex.admin.system.dto.query.UserMenuQueryDTO;
import com.aiex.admin.system.service.AuthService;
import com.aiex.admin.system.service.MenuService;
import com.aiex.framework.security.service.TokenService;
import com.aiex.framework.web.base.Result;
import com.aiex.framework.web.enums.WebErrorCodeEnum;
import com.aiex.framework.web.exception.BizException;
import com.aiex.framework.web.redis.RedisCache;
import com.wf.captcha.SpecCaptcha;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${aiex.security.captcha.enabled}")
    private Boolean captchaEnable;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private AuthService authService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private TokenService tokenService;

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
        redisCache.setCacheObject(uuid, verCode, 1, TimeUnit.MINUTES);
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
            BizException.isTrue(ObjectUtil.equal(localCaptcha, loginDTO.getCode()), WebErrorCodeEnum.FAIL);
        }
        // 登录生成token
        String token = authService.login(loginDTO);
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
        UserAuthDTO userAuthDTO = authService.getUserInfo();
        List<MenuDTO> menuDTOList;
        if(!userAuthDTO.isAdmin()){
            UserMenuQueryDTO menuQueryDTO = new UserMenuQueryDTO();
            menuQueryDTO.setUserId(userAuthDTO.getId());
            menuDTOList = menuService.listUserTreeByQuery(menuQueryDTO);
        }else{
            MenuQueryDTO menuQueryDTO = new MenuQueryDTO();
            menuDTOList = menuService.listTreeByQuery(menuQueryDTO);
        }
        return Result.ok(menuDTOList);
    }

    /**
     * 获取当前登录用户信息
     * @return User
     */
    @GetMapping("/getUserInfo")
    public Result<UserDTO> getUserInfo(){
        UserDTO user = authService.getUserInfo();
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
    @GetMapping("/refresh")
    public Result<Void> refresh(HttpServletRequest request){
        tokenService.verifyToken(request);
        return Result.ok();
    }

    /**
     * 退出登录
     * @return Void
     */
    @PostMapping("/logout")
    public Result<Void> logout(HttpServletRequest request){
        tokenService.invalidToken(request);
        return Result.ok();
    }




}
