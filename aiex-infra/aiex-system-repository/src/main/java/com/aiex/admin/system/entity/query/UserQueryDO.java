package com.aiex.admin.system.entity.query;


import com.aiex.framework.db.config.base.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryDO extends PageDTO<UserQueryDO> {

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
