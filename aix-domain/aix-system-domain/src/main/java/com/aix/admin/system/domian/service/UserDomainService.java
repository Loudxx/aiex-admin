package com.aix.admin.system.domian.service;

import com.aix.admin.system.domian.domain.UserDomain;
import com.aix.admin.system.domian.domain.query.UserQueryDomain;
import com.aix.framework.db.config.base.PageDTO;

import java.util.List;

public interface UserDomainService {

    /**
     * 分页查询
     * @param userQueryDomain
     * @return
     */
    PageDTO<UserDomain> pageByQuery(UserQueryDomain userQueryDomain);

    /**
     * 保存
     * @param userDomain
     */
    void save(UserDomain userDomain);

    /**
     * 根据ids删除
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserDomain getById(Long id);
}
