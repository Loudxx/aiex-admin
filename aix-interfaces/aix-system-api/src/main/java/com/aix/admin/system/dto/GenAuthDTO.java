package com.aix.admin.system.dto;

import lombok.Data;

import java.util.List;

@Data
public class GenAuthDTO {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 角色
     */
    private List<Long> menuIds;

}
