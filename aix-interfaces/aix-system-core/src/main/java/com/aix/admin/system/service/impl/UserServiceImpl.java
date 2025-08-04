package com.aix.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aix.admin.system.domian.domain.GenRoleDomain;
import com.aix.admin.system.domian.domain.UserDomain;
import com.aix.admin.system.domian.domain.UserPassWordDomain;
import com.aix.admin.system.domian.domain.UserStatusDomain;
import com.aix.admin.system.domian.domain.query.UserQueryDomain;
import com.aix.admin.system.domian.service.AuthDomainService;
import com.aix.admin.system.domian.service.UserDomainService;
import com.aix.admin.system.dto.GenRoleDTO;
import com.aix.admin.system.dto.UserDTO;
import com.aix.admin.system.dto.UserPassWordDTO;
import com.aix.admin.system.dto.UserStatusDTO;
import com.aix.admin.system.dto.query.UserQueryDTO;
import com.aix.admin.system.service.UserService;
import com.aix.framework.db.config.base.PageDTO;
import com.aix.framework.db.config.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDomainService userDomainService;

    @Autowired
    private AuthDomainService authDomainService;


    @Override
    public PageDTO<UserDTO> pageByQuery(UserQueryDTO userQueryDTO) {
        UserQueryDomain userQueryDomain = BeanUtil.toBean(userQueryDTO, UserQueryDomain.class);
        PageDTO<UserDomain> pageDTO = userDomainService.pageByQuery(userQueryDomain);
        return PageUtils.copy(pageDTO, UserDTO.class);
    }

    @Override
    public void save(UserDTO userDTO) {
        UserDomain userDomain = BeanUtil.toBean(userDTO, UserDomain.class);
        //设置默认属性
        setDefaultInfo(userDomain);
        userDomainService.save(userDomain);
    }

    private void setDefaultInfo(UserDomain userDomain) {
        userDomain.setStatus(0);
        String password = "123456";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passHash = encoder.encode(password);
        userDomain.setPassword(passHash);
    }

    @Override
    public UserDTO getById(Long id) {
        UserDomain userDomain = userDomainService.getById(id);
        return BeanUtil.toBean(userDomain, UserDTO.class);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        userDomainService.deleteByIds(ids);
    }

    @Override
    public void updateStatus(UserStatusDTO userStatusDTO) {
        UserStatusDomain userStatusDomain = BeanUtil.toBean(userStatusDTO, UserStatusDomain.class);
        userDomainService.updateStatus(userStatusDomain);
    }

    @Override
    public void updatePassWord(UserPassWordDTO userPassWordDTO) {
        UserPassWordDomain userPassWordDomain = BeanUtil.toBean(userPassWordDTO, UserPassWordDomain.class);
        userDomainService.updatePassWord(userPassWordDomain);
    }

    @Override
    public void resetPassWord(Long id) {
        userDomainService.resetPassWord(id);
    }

}
