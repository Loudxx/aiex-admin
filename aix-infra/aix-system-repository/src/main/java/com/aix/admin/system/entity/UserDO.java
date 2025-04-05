package com.aix.admin.system.entity;

import com.aix.framework.security.bo.LoginUser;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table("sys_user")
public class UserDO extends LoginUser {

    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态
     */
    private String status;

    /**
     * 角色列表
     */
    private List<RoleDO> roles;

    /**
     * 权限列表
     */
    private List<MenuDO> menus;

    /**
     * 是否是超级管理员角色
     * @return boolean
     */
    public boolean isAdmin() {
        return roles.stream().anyMatch(e->e.getCode().equals("admin"));
    }
}
