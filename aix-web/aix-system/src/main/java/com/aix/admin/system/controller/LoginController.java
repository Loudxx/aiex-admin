package com.aix.admin.system.controller;

import cn.hutool.core.util.ObjectUtil;
import com.aix.admin.system.dto.LoginDTO;
import com.aix.admin.system.entity.User;
import com.aix.admin.system.service.LoginService;
import com.aix.framework.core.base.Result;
import com.aix.framework.core.enums.ErrorCodeEnum;
import com.aix.framework.web.exception.BizException;
import com.aix.framework.web.redis.RedisCache;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private LoginService loginService;

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
        String localCaptcha = redisCache.getCacheObject(loginDTO.getUuid());
        // 校验验证码
        BizException.isTrue(ObjectUtil.equal(localCaptcha, loginDTO.getCode()), ErrorCodeEnum.FAIL);
        // 登录生成token
        String token = loginService.login(loginDTO);
        Map<String, Object> map = new HashMap<>(1);
        map.put("token", token);
        return Result.ok(map);
    }

    /**
     * 获取当前登录用户信息
     * @return User
     */
    @GetMapping("/getUserInfo")
    public Result<User> getUserInfo(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Result.ok(user);
    }



}
