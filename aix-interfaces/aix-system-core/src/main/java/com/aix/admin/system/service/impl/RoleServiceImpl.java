package com.aix.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aix.admin.system.domian.domain.RoleDomain;
import com.aix.admin.system.domian.domain.query.RoleQueryDomain;
import com.aix.admin.system.domian.service.RoleDomainService;
import com.aix.admin.system.dto.RoleDTO;
import com.aix.admin.system.dto.query.RoleQueryDTO;
import com.aix.admin.system.service.RoleService;
import com.aix.framework.db.config.base.PageDTO;
import com.aix.framework.db.config.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDomainService roleDomainService;


    @Override
    public PageDTO<RoleDTO> pageByQuery(RoleQueryDTO roleQueryDTO) {
        RoleQueryDomain queryDomain = BeanUtil.toBean(roleQueryDTO, RoleQueryDomain.class);
        PageDTO<RoleDomain> pageDTO = roleDomainService.pageByQuery(queryDomain);
        return PageUtils.copy(pageDTO, RoleDTO.class);
    }

    @Override
    public void save(RoleDTO roleDTO) {
        RoleDomain roleDomain = BeanUtil.toBean(roleDTO, RoleDomain.class);
        roleDomainService.save(roleDomain);
    }

    @Override
    public RoleDTO getById(Long id) {
        RoleDomain roleDomain = roleDomainService.getById(id);
        return BeanUtil.toBean(roleDomain, RoleDTO.class);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        roleDomainService.deleteByIds(ids);
    }
}
