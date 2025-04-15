package com.aix.admin.system.domian.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aix.admin.system.domian.domain.MenuDomain;
import com.aix.admin.system.domian.service.MenuDomainService;
import com.aix.admin.system.entity.MenuDO;
import com.aix.admin.system.mapper.MenuMapper;
import com.aix.framework.web.utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MenuDomainServiceImpl implements MenuDomainService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<MenuDomain> listTreeByUserId(Long userId) {
        List<MenuDO> menuDOList = menuMapper.selectListByUserId(userId);
        return converMenuDomainList(menuDOList);
    }

    @Override
    public List<MenuDomain> selectAll() {
        List<MenuDO> menuDOList = menuMapper.selectAll();
        return converMenuDomainList(menuDOList);
    }

    private List<MenuDomain> converMenuDomainList(List<MenuDO> menuDOList) {
        return menuDOList.stream().map(e->{
            MenuDomain menuDomain = new MenuDomain();
            BeanUtil.copyProperties(e, menuDomain, "meta");
            menuDomain.setMeta(JacksonUtils.parseObject(e.getMeta(), Map.class));
            return menuDomain;
        }).collect(Collectors.toList());
    }
}
