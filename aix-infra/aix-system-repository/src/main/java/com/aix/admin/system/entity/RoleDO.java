package com.aix.admin.system.entity;

import com.aix.framework.db.config.base.BaseDO;
import com.aix.framework.db.config.listener.FlexInsertListener;
import com.aix.framework.db.config.listener.FlexUpdateListener;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(value = "sys_role", onInsert = FlexInsertListener.class, onUpdate = FlexUpdateListener.class)
public class RoleDO extends BaseDO {

    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 状态
     */
    private Integer status;


}
