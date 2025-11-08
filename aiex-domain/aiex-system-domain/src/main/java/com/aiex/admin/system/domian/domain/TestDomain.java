package com.aiex.admin.system.domian.domain;

import com.aiex.framework.core.base.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TestDomain extends BaseDomain {

    private String userName;
    private Integer age;

}