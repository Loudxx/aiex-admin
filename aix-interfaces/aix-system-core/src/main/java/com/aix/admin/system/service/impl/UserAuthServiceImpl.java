package com.aix.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aix.admin.system.domian.domain.GenRoleDomain;
import com.aix.admin.system.domian.domain.UserAuthDomain;
import com.aix.admin.system.domian.service.UserAuthDomainService;
import com.aix.admin.system.dto.GenRoleDTO;
import com.aix.admin.system.dto.UserAuthDTO;
import com.aix.admin.system.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserAuthDomainService userAuthDomainService;

    @Override
    public UserAuthDTO getById(Long id) {
        UserAuthDomain userAuthDomain = userAuthDomainService.getById(id);
        return BeanUtil.toBean(userAuthDomain, UserAuthDTO.class);
    }

    @Override
    public void save(UserAuthDTO userAuthDTO) {
        UserAuthDomain userAuthDomain = BeanUtil.toBean(userAuthDTO, UserAuthDomain.class);
        userAuthDomainService.save(userAuthDomain);
    }

    @Override
    public void genRole(GenRoleDTO genRoleDTO) {
        GenRoleDomain genRoleDomain = BeanUtil.toBean(genRoleDTO, GenRoleDomain.class);
        userAuthDomainService.genRole(genRoleDomain);
    }
}
