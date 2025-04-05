package com.aix.admin.system.entity;

import com.aix.framework.db.config.base.BaseDO;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table("test")
public class TestDO extends BaseDO {

    private String userName;
    private Integer age;

}