package com.aix.admin.system.domian.domain;

import com.aix.framework.core.base.BaseDomain;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("test")
public class TestDomain extends BaseDomain {

    @Id(keyType = KeyType.Auto)
    private Long id;
    private String userName;
    private Integer age;

}