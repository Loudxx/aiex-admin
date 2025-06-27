package com.aix.admin.system.service.impl;

import com.aix.admin.system.domian.domain.UserDomain;
import com.aix.admin.system.domian.service.UserAuthDomainService;
import com.aix.admin.system.domian.service.UserDomainService;
import com.aix.admin.system.entity.MenuDO;
import com.aix.admin.system.entity.RoleDO;
import com.aix.admin.system.entity.UserDO;
import com.aix.admin.system.entity.query.UserMenuQueryDO;
import com.aix.admin.system.mapper.MenuMapper;
import com.aix.admin.system.mapper.RoleMapper;
import com.aix.admin.system.mapper.UserMapper;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAuthDomainService userAuthDomainService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDomain user = userAuthDomainService.getByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }

}
