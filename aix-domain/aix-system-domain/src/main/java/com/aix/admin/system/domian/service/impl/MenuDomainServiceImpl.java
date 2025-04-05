package com.aix.admin.system.domian.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aix.admin.system.domian.domain.MenuDomain;
import com.aix.admin.system.domian.service.MenuDomainService;
import com.aix.admin.system.entity.MenuDO;
import com.aix.admin.system.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuDomainServiceImpl implements MenuDomainService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<MenuDomain> listTreeByUserId(Long userId) {
        List<MenuDO> menuDOList = menuMapper.selectListByUserId(userId);
        return BeanUtil.copyToList(menuDOList, MenuDomain.class);
    }
}
