package com.aix.admin.system.domian.service;

import com.aix.admin.system.domian.domain.UserDomain;

public interface AuthDomainService {

    /**
     * 获取登录用户信息
     * @return
     */
    UserDomain getUserInfo();
}
