package com.aix.admin.system.dto;

import lombok.Data;

@Data
public class UserStatusDTO {
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 状态
     */
    private Integer status;

}
