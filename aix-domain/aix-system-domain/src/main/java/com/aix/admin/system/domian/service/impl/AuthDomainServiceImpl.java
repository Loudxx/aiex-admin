package com.aix.admin.system.domian.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aix.admin.system.domian.domain.UserDomain;
import com.aix.admin.system.domian.service.AuthDomainService;
import com.aix.admin.system.entity.UserDO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthDomainServiceImpl implements AuthDomainService {

    @Override
    public UserDomain getUserInfo() {
        UserDO user = (UserDO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return BeanUtil.toBean(user, UserDomain.class);
    }

}
