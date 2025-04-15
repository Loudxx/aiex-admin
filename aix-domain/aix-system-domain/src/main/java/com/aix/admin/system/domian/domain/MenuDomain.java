package com.aix.admin.system.domian.domain;

import com.aix.framework.core.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class MenuDomain extends BaseDomain {

    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单编码
     */
    private String code;
    /**
     * 菜单路径
     */
    private String path;
    /**
     * 菜单类型
     */
    private String type;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 图标
     */
    private String icon;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 组件
     */
    private String component;
    /**
     * 重定向地址
     */
    private String redirect;
    private Map meta;

}
