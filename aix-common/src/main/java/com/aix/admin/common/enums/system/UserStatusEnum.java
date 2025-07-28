package com.aix.admin.common.enums.system;

import com.aix.framework.core.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatusEnum implements EnumInterface {

    ENABLE("启用", 0),
    DISABLE("禁用", 1),
    ;

    /**
     * 名称
     */
    private final String label;
    /**
     * 值
     */
    private final Integer value;

}
