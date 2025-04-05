package com.aix.admin.system.dto;

import com.aix.framework.core.base.BaseDTO;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("sys_role")
public class RoleDTO extends BaseDTO {

    @Id(keyType = KeyType.Auto)
    private Long id;

}
