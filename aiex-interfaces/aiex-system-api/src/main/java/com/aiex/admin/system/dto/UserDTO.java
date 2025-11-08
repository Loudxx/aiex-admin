package com.aiex.admin.system.dto;

import lombok.Data;

@Data
public class UserDTO{

    private Long id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态
     */
    private Integer status;

}
