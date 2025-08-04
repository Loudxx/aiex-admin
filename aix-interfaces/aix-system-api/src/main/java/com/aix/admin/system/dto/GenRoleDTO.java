package com.aix.admin.system.dto;

import lombok.Data;

import java.util.List;

@Data
public class GenRoleDTO {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 角色
     */
    private List<Long> roleIds;

}
