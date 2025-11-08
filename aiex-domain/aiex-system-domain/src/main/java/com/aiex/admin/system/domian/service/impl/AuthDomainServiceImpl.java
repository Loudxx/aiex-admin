package com.aiex.admin.system.domian.service.impl;

import com.aiex.admin.system.domian.domain.UserAuthDomain;
import com.aiex.admin.system.domian.service.AuthDomainService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthDomainServiceImpl implements AuthDomainService {

    @Override
    public UserAuthDomain getUserInfo() {
        return (UserAuthDomain) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
