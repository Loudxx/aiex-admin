package com.aiex.admin.system.domian.domain;

import lombok.Data;

@Data
public class RoleStatusDomain {

    /**
     * 角色主键
     */
    private Long roleId;
    /**
     * 状态
     */
    private Integer status;

}
