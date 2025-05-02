package com.aix.admin.system.domian.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aix.admin.system.domian.domain.UserDomain;
import com.aix.admin.system.domian.domain.query.UserQueryDomain;
import com.aix.admin.system.domian.service.UserDomainService;
import com.aix.admin.system.entity.UserDO;
import com.aix.admin.system.entity.query.UserQueryDO;
import com.aix.admin.system.mapper.UserMapper;
import com.aix.framework.db.config.base.PageDTO;
import com.aix.framework.db.config.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        userMapper.insertOrUpdate(userDO);
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
}
