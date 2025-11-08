package com.aiex.admin.system.domian.domain;

import com.aiex.framework.core.base.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDomain extends BaseDomain {

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
