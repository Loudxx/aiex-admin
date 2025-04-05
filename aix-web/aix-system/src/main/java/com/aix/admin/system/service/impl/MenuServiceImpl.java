package com.aix.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aix.admin.system.domian.domain.MenuDomain;
import com.aix.admin.system.domian.service.MenuDomainService;
import com.aix.admin.system.dto.MenuDTO;
import com.aix.admin.system.service.MenuService;
import com.aix.framework.core.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Long rooId = 0L;

    @Autowired
    private MenuDomainService menuDomainService;


    @Override
    public List<MenuDTO> listTreeByUserId(Long userId) {
        List<MenuDomain> menuDomainList = menuDomainService.listTreeByUserId(userId);
        List<MenuDTO> menuDTOList = BeanUtil.copyToList(menuDomainList, MenuDTO.class);
        return TreeUtils.toTree(menuDTOList, rooId);
    }

    @Override
    public List<MenuDTO> selectAllTree() {
        List<MenuDomain> menuDomainList = menuDomainService.selectAll();
        List<MenuDTO> menuDTOList = BeanUtil.copyToList(menuDomainList, MenuDTO.class);
        return TreeUtils.toTree(menuDTOList, rooId);
    }
}
