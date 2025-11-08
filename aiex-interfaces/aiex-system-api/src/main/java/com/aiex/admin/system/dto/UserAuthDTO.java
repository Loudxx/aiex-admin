package com.aiex.admin.system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class UserAuthDTO extends UserDTO{
    /**
     * 角色列表
     */
    private List<RoleDTO> roles;

    /**
     * 权限列表
     */
    @JsonIgnore
    private List<MenuDTO> menus;

    /**
     * 是否是超级管理员角色
     * @return boolean
     */
    @JsonIgnore
    public boolean isAdmin() {
        return roles.stream().anyMatch(e->e.getCode().equals("admin"));
    }

}
