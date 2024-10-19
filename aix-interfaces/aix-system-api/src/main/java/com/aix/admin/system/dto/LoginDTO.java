package com.aix.admin.system.dto;

import lombok.Data;

@Data
public class LoginDTO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;
    /**
     * 获取验证码的时间戳
     */
    private String uuid;




}
