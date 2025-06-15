package com.aix.admin.system.dto.query;

import com.aix.framework.db.config.base.PageDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserQueryDTO extends PageDTO<UserQueryDTO> {

    /**
     * 用户名
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 状态
     */
    private String status;
    /**
     * 创建时间开始
     */
    private String createTimeStart;
    /**
     * 创建时间结束
     */
    private String createTimeEnd;

}
