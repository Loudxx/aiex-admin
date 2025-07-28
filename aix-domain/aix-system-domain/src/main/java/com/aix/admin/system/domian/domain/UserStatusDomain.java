package com.aix.admin.system.domian.domain;

import lombok.Data;

@Data
public class UserStatusDomain {

    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 状态
     */
    private Integer status;

}
