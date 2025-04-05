package com.aix.admin.system.domian.domain;

import com.aix.framework.core.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TestDomain extends BaseDomain {

    private String userName;
    private Integer age;

}