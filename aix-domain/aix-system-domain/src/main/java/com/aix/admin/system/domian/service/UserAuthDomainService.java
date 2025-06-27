package com.aix.admin.system.domian.service;

import com.aix.admin.system.domian.domain.UserAuthDomain;

public interface UserAuthDomainService {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    UserAuthDomain getByUserName(String username);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserAuthDomain getById(Long id);

    /**
     * 保存
     * @param userAuthDomain
     */
    void save(UserAuthDomain userAuthDomain);
}
