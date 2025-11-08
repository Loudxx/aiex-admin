package com.aiex.admin.system.entity;

import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("sys_user_role")
public class UserRoleDO {

    private Long userId;

    private Long roleId;

}
