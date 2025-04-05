package com.aix.admin.system.dto;

import com.aix.framework.core.base.BaseDTO;
import com.aix.framework.core.base.BaseTreeDTO;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("sys_menu")
public class MenuDTO extends BaseTreeDTO {

    @Id(keyType = KeyType.Auto)
    private Long id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单路径
     */
    private String path;



}
