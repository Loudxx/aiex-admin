package com.aix.admin.system.domian.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.aix.admin.system.domian.domain.UserDomain;
import com.aix.admin.system.domian.domain.UserPassWordDomain;
import com.aix.admin.system.domian.domain.UserStatusDomain;
import com.aix.admin.system.domian.domain.query.UserQueryDomain;
import com.aix.admin.system.domian.service.UserDomainService;
import com.aix.admin.system.entity.UserDO;
import com.aix.admin.system.entity.query.UserQueryDO;
import com.aix.admin.system.mapper.UserMapper;
import com.aix.framework.db.config.base.PageDTO;
import com.aix.framework.db.config.utils.PageUtils;
import com.aix.framework.web.enums.WebErrorCodeEnum;
import com.aix.framework.web.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageDTO<UserDomain> pageByQuery(UserQueryDomain userQueryDomain) {
        UserQueryDO userQueryPO = BeanUtil.toBean(userQueryDomain, UserQueryDO.class);
        PageDTO<UserDO> userDO =  userMapper.pageByQuery(userQueryPO);
        return PageUtils.copy(userDO, UserDomain.class);
    }

    @Override
    public void save(UserDomain userDomain) {
        UserDO userDO = BeanUtil.toBean(userDomain, UserDO.class);
        //保存用户
        userMapper.insertOrUpdateSelective(userDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        userMapper.deleteBatchByIds(ids);
    }

    @Override
    public UserDomain getById(Long id) {
        UserDO userDO = userMapper.selectOneById(id);
        return BeanUtil.toBean(userDO, UserDomain.class);
    }

    @Override
    public void updateStatus(UserStatusDomain userStatusDomain) {
        UserDO userDO = new UserDO();
        userDO.setId(userStatusDomain.getUserId());
        userDO.setStatus(userStatusDomain.getStatus());
        userMapper.update(userDO, true);
    }

    @Override
    public void updatePassWord(UserPassWordDomain userPassWordDomain) {
        UserDO userDO = userMapper.selectOneById(userPassWordDomain.getUserId());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean matches = encoder.matches(userPassWordDomain.getOldPassWord(), userDO.getPassword());
        BizException.isTrue(matches, WebErrorCodeEnum.FAIL);
        UserDO userUpdateDO = new UserDO();
        userUpdateDO.setId(userPassWordDomain.getUserId());
        userUpdateDO.setPassword(userPassWordDomain.getNewPassWord());
        userMapper.update(userDO, true);
    }

    @Override
    public void resetPassWord(Long id) {
        UserDO userUpdateDO = new UserDO();
        userUpdateDO.setId(id);
        String password = "123456";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passHash = encoder.encode(password);
        userUpdateDO.setPassword(passHash);
        userMapper.update(userUpdateDO, true);
    }
}
