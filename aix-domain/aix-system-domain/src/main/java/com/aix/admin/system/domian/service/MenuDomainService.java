package com.aix.admin.system.domian.service;

import com.aix.admin.system.domian.domain.MenuDomain;
import com.aix.admin.system.domian.domain.query.MenuQueryDomain;
import com.aix.admin.system.domian.domain.query.UserMenuQueryDomain;

import java.util.List;

public interface MenuDomainService {

    /**
     * 根据条件查询
     * @param menuQueryDomain
     * @return
     */
    List<MenuDomain> listByQuery(MenuQueryDomain menuQueryDomain);

    /**
     * 保存
     * @param menuDomain
     */
    void save(MenuDomain menuDomain);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    MenuDomain getById(Long id);

    /**
     * 根据ids删除
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     *
     * @param userMenuQueryDomain
     * @return
     */
    List<MenuDomain> listUserByQuery(UserMenuQueryDomain userMenuQueryDomain);
}
