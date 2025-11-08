package com.aiex.admin.system.dto;

import lombok.Data;

@Data
public class RoleStatusDTO {
    /**
     * 角色主键
     */
    private Long roleId;
    /**
     * 状态
     */
    private Integer status;

}
