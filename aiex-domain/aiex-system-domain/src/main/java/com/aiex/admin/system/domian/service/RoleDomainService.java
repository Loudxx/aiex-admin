package com.aiex.admin.system.domian.service;

import com.aiex.admin.system.domian.domain.GenAuthDomain;
import com.aiex.admin.system.domian.domain.RoleDomain;
import com.aiex.admin.system.domian.domain.RoleStatusDomain;
import com.aiex.admin.system.domian.domain.query.RoleQueryDomain;
import com.aiex.framework.db.config.base.PageDTO;

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

    /**
     * 修改状态
     * @param roleStatusDomain
     */
    void updateStatus(RoleStatusDomain roleStatusDomain);

    /**
     * 授权
     * @param genAuthDomain
     */
    void genAuth(GenAuthDomain genAuthDomain);

    /**
     * 获取权限信息
     * @param id
     * @return
     */
    List<Long> genAuthDetail(Long id);
}
