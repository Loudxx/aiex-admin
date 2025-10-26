package com.aix.admin.system.entity;

import com.aix.framework.db.config.base.BaseDO;
import com.aix.framework.db.config.listener.FlexInsertListener;
import com.aix.framework.db.config.listener.FlexUpdateListener;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(value = "sys_menu", onInsert = FlexInsertListener.class, onUpdate = FlexUpdateListener.class)
public class MenuDO extends BaseDO {

    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单路径
     */
    private String path;
    /**
     * 菜单类型
     */
    private String type;
    /**
     * 父级id
     */
    private Long parentId;
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

    private String meta;
    /**
     * 激活路径
     */
    private String activePath;
    /**
     * 跳转链接
     */
    private String linkSrc;


}
