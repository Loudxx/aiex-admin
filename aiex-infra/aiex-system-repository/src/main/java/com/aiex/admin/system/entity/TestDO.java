package com.aiex.admin.system.entity;

import com.aiex.framework.db.config.base.BaseDO;
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