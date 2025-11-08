package com.aiex.admin.system.domian.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.aiex.admin.system.domian.domain.MenuDomain;
import com.aiex.admin.system.domian.domain.query.MenuQueryDomain;
import com.aiex.admin.system.domian.domain.query.UserMenuQueryDomain;
import com.aiex.admin.system.domian.service.MenuDomainService;
import com.aiex.admin.system.entity.MenuDO;
import com.aiex.admin.system.entity.query.MenuQueryDO;
import com.aiex.admin.system.entity.query.UserMenuQueryDO;
import com.aiex.admin.system.mapper.MenuMapper;
import com.aiex.framework.web.utils.JacksonUtils;
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
    public List<MenuDomain> listByQuery(MenuQueryDomain menuQueryDomain) {
        MenuQueryDO menuQueryDO = BeanUtil.toBean(menuQueryDomain, MenuQueryDO.class);
        List<MenuDO> menuDOList = menuMapper.listByQuery(menuQueryDO);
        return converMenuDomainList(menuDOList);
    }

    @Override
    public void save(MenuDomain menuDomain) {
        MenuDO menuDO = BeanUtil.toBean(menuDomain, MenuDO.class);
        if(ObjectUtil.isNotEmpty(menuDO.getMeta())){
            menuDO.setMeta(JSONUtil.toJsonStr(menuDomain.getMeta()));
        }
        menuMapper.insertOrUpdateSelective(menuDO);
    }

    @Override
    public MenuDomain getById(Long id) {
        MenuDO menuDO =  menuMapper.selectOneById(id);
        return converMenuDomain(menuDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        menuMapper.deleteBatchByIds(ids);
    }

    @Override
    public List<MenuDomain> listUserByQuery(UserMenuQueryDomain userMenuQueryDomain) {
        UserMenuQueryDO userMenuQueryDO = BeanUtil.toBean(userMenuQueryDomain, UserMenuQueryDO.class);
        List<MenuDO> menuDOList = menuMapper.listUserByQuery(userMenuQueryDO);
        return converMenuDomainList(menuDOList);
    }

    private List<MenuDomain> converMenuDomainList(List<MenuDO> menuDOList) {
        return menuDOList.stream().map(e->{
            MenuDomain menuDomain = new MenuDomain();
            BeanUtil.copyProperties(e, menuDomain, "meta");
            if(ObjectUtil.isNotEmpty(e.getMeta())){
                menuDomain.setMeta(JacksonUtils.parseObject(e.getMeta(), Map.class));
            }
            return menuDomain;
        }).collect(Collectors.toList());
    }

    private MenuDomain converMenuDomain(MenuDO menuDO) {
        MenuDomain menuDomain = new MenuDomain();
        BeanUtil.copyProperties(menuDO, menuDomain, "meta");
        menuDomain.setMeta(JacksonUtils.parseObject(menuDO.getMeta(), Map.class));
        return menuDomain;
    }
}
