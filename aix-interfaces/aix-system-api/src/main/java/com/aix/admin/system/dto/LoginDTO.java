package com.aix.admin.system.dto;

import lombok.Data;

@Data
public class LoginDTO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 验证码
     */
    private String captcha;
    /**
     * 获取验证码的时间戳
     */
    private String key;




}
