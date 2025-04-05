package com.aix.admin.system.domian.service;

import com.aix.admin.system.domian.domain.MenuDomain;

import java.util.List;

public interface MenuDomainService {

    /**
     * 根据用户id查询菜单
     * @param userId
     * @return
     */
    List<MenuDomain> listTreeByUserId(Long userId);
}
