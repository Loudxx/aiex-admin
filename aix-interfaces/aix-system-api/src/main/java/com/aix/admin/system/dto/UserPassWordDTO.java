package com.aix.admin.system.dto;

import lombok.Data;

@Data
public class UserPassWordDTO {

    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 旧密码
     */
    private String oldPassWord;

    /**
     * 新密码
     */
    private String newPassWord;


}
