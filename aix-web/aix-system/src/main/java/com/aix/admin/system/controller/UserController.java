package com.aix.admin.system.controller;

import com.aix.admin.system.entity.User;
import com.aix.framework.core.base.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 获取当前登录用户信息
     * @return User
     */
    @GetMapping("/info")
    public Result<User> getUserInfo(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Result.ok(user);
    }

}
