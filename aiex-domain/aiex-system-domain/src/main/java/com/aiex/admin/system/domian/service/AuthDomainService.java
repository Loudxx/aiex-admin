package com.aiex.admin.system.domian.service;

import com.aiex.admin.system.domian.domain.UserAuthDomain;

public interface AuthDomainService {

    /**
     * 获取登录用户信息
     * @return
     */
    UserAuthDomain getUserInfo();
}
