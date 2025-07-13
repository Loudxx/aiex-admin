package com.aix.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aix.admin.system.domian.domain.MenuDomain;
import com.aix.admin.system.domian.domain.query.MenuQueryDomain;
import com.aix.admin.system.domian.domain.query.UserMenuQueryDomain;
import com.aix.admin.system.domian.service.MenuDomainService;
import com.aix.admin.system.dto.MenuDTO;
import com.aix.admin.system.dto.query.MenuQueryDTO;
import com.aix.admin.system.dto.query.UserMenuQueryDTO;
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
    public List<MenuDTO> listTreeByQuery(MenuQueryDTO menuQueryDTO) {
        List<MenuDTO> menuDTOList = listByQuery(menuQueryDTO);
        return TreeUtils.toTree(menuDTOList, rooId);
    }

    @Override
    public void save(MenuDTO menuDTO) {
        MenuDomain menuDomain = BeanUtil.toBean(menuDTO, MenuDomain.class);
        menuDomain.setStatus(0);
        menuDomainService.save(menuDomain);
    }

    @Override
    public MenuDTO getById(Long id) {
        MenuDomain menuDomain = menuDomainService.getById(id);
        return BeanUtil.toBean(menuDomain, MenuDTO.class);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        menuDomainService.deleteByIds(ids);
    }

    @Override
    public List<MenuDTO> listUserTreeByQuery(UserMenuQueryDTO userMenuQueryDTO) {
        UserMenuQueryDomain userMenuQueryDomain = BeanUtil.toBean(userMenuQueryDTO, UserMenuQueryDomain.class);
        List<MenuDomain> menuDomainList = menuDomainService.listUserByQuery(userMenuQueryDomain);
        List<MenuDTO> menuDTOList = BeanUtil.copyToList(menuDomainList, MenuDTO.class);
        return TreeUtils.toTree(menuDTOList, rooId);
    }

    @Override
    public List<MenuDTO> listByQuery(MenuQueryDTO menuQueryDTO) {
        MenuQueryDomain menuQueryDomain = BeanUtil.toBean(menuQueryDTO, MenuQueryDomain.class);
        List<MenuDomain> menuDomainList = menuDomainService.listByQuery(menuQueryDomain);
        return BeanUtil.copyToList(menuDomainList, MenuDTO.class);
    }
}
