package com.aiex.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.aiex.admin.system.domian.domain.GenAuthDomain;
import com.aiex.admin.system.domian.domain.RoleDomain;
import com.aiex.admin.system.domian.domain.RoleStatusDomain;
import com.aiex.admin.system.domian.domain.query.RoleQueryDomain;
import com.aiex.admin.system.domian.service.RoleDomainService;
import com.aiex.admin.system.dto.GenAuthDTO;
import com.aiex.admin.system.dto.RoleDTO;
import com.aiex.admin.system.dto.RoleStatusDTO;
import com.aiex.admin.system.dto.query.RoleQueryDTO;
import com.aiex.admin.system.service.RoleService;
import com.aiex.framework.db.config.base.PageDTO;
import com.aiex.framework.db.config.utils.PageUtils;
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
        if(ObjectUtil.isEmpty(roleDomain.getStatus())){
            roleDomain.setStatus(0);
        }
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

    @Override
    public List<RoleDTO> listByQuery(RoleQueryDTO roleQueryDTO) {
        RoleQueryDomain queryDomain = BeanUtil.toBean(roleQueryDTO, RoleQueryDomain.class);
        List<RoleDomain> roleDomainList =  roleDomainService.listByQuery(queryDomain);
        return BeanUtil.copyToList(roleDomainList, RoleDTO.class);
    }

    @Override
    public void updateStatus(RoleStatusDTO roleStatusDTO) {
        RoleStatusDomain roleStatusDomain = BeanUtil.toBean(roleStatusDTO, RoleStatusDomain.class);
        roleDomainService.updateStatus(roleStatusDomain);
    }

    @Override
    public void genAuth(GenAuthDTO genAuthDTO) {
        GenAuthDomain genAuthDomain = BeanUtil.toBean(genAuthDTO, GenAuthDomain.class);
        roleDomainService.genAuth(genAuthDomain);
    }

    @Override
    public List<Long> genAuthDetail(Long id) {
        return roleDomainService.genAuthDetail(id);
    }
}
