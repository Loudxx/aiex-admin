package com.aix.admin.system.dto.query;

import lombok.Data;

@Data
public class UserQueryDTO {

    /**
     * 用户名
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 状态
     */
    private String status;

}
