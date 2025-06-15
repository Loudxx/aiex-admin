package com.aix.admin.system.dto;

import com.aix.framework.security.bo.LoginUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class UserDTO{

    private Long id;
    /**
     * 用户名
     */
    private String username;

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
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 角色列表
     */
    private List<RoleDTO> roles;

    /**
     * 权限列表
     */
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
