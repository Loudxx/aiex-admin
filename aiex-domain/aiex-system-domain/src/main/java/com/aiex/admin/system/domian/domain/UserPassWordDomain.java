package com.aiex.admin.system.domian.domain;

import lombok.Data;

@Data
public class UserPassWordDomain {

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
