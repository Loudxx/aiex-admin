package com.aix.admin.system.dto;

import com.aix.framework.core.base.dto.BaseDTO;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
public class RoleDTO extends BaseDTO {

    @Id(keyType = KeyType.Auto)
    private Long id;
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
