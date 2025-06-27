package com.aix.admin.system.domian.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserAuthDomain extends UserDomain {

    /**
     * 角色列表
     */
    private List<RoleDomain> roles;

    /**
     * 权限列表
     */
    private List<MenuDomain> menus;

}
