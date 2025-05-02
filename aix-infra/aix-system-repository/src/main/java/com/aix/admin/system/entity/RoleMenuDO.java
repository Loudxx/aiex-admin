package com.aix.admin.system.entity;

import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("sys_role_menu")
public class RoleMenuDO {

    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 菜单id
     */
    private Long menuId;

}
