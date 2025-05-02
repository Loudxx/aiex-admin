package com.aix.admin.system.domian.domain.query;

import com.aix.framework.core.base.Page;
import lombok.Data;

@Data
public class UserQueryDomain extends Page<UserQueryDomain> {

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


}
