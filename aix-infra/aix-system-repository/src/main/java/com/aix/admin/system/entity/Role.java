package com.aix.admin.system.entity;

import com.aix.framework.security.bo.LoginUser;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("sys_role")
public class Role{

    @Id(keyType = KeyType.Auto)
    private Long id;

}
