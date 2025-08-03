package com.aix.admin.system.domian.service;

import com.aix.admin.system.domian.domain.RoleDomain;
import com.aix.admin.system.domian.domain.query.RoleQueryDomain;
import com.aix.framework.db.config.base.PageDTO;

import java.util.List;

public interface RoleDomainService {
    /**
     * 分页查询
     * @param queryDomain
     * @return
     */
    PageDTO<RoleDomain> pageByQuery(RoleQueryDomain queryDomain);

    /**
     * 保存
     * @param roleDomain
     */
    void save(RoleDomain roleDomain);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    RoleDomain getById(Long id);

    /**
     * 根据ids删除
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 条件查询
     * @param queryDomain
     * @return
     */
    List<RoleDomain> listByQuery(RoleQueryDomain queryDomain);
}
