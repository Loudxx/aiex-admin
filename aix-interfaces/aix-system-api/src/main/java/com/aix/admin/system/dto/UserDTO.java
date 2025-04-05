package com.aix.admin.system.dto;

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
public class UserDTO extends LoginUser {

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
    private List<RoleDTO> roles;

    /**
     * 权限列表
     */
    private List<MenuDTO> menus;

}
