package com.aix.admin.system.domian.domain;

import com.aix.framework.core.base.BaseDomain;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("sys_role")
public class RoleDomain extends BaseDomain {

    @Id(keyType = KeyType.Auto)
    private Long id;

}
