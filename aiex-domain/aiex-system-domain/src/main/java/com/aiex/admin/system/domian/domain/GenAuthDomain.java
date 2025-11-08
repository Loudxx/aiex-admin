package com.aiex.admin.system.domian.domain;

import lombok.Data;

import java.util.List;

@Data
public class GenAuthDomain {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 角色
     */
    private List<Long> menuIds;

}
