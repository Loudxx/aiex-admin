package com.aix.admin.system.entity;

import com.aix.framework.db.config.listener.FlexInsertListener;
import com.aix.framework.db.config.listener.FlexUpdateListener;
import com.aix.framework.security.bo.LoginUser;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(value = "sys_user", onInsert = FlexInsertListener.class, onUpdate = FlexUpdateListener.class)
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
    @Column(ignore = true)
    private List<RoleDO> roles;

    /**
     * 权限列表
     */
    @Column(ignore = true)
    private List<MenuDO> menus;

}
