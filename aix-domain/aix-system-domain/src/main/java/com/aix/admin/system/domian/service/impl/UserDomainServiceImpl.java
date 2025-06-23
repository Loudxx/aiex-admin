package com.aix.admin.system.domian.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import com.aix.admin.system.domian.domain.RoleDomain;
import com.aix.admin.system.domian.domain.UserDomain;
import com.aix.admin.system.domian.domain.query.UserQueryDomain;
import com.aix.admin.system.domian.service.UserDomainService;
import com.aix.admin.system.entity.UserDO;
import com.aix.admin.system.entity.UserRoleDO;
import com.aix.admin.system.entity.query.UserQueryDO;
import com.aix.admin.system.entity.table.UserDOTableDef;
import com.aix.admin.system.entity.table.UserRoleDOTableDef;
import com.aix.admin.system.mapper.UserMapper;
import com.aix.admin.system.mapper.UserRoleMapper;
import com.aix.framework.db.config.base.PageDTO;
import com.aix.framework.db.config.utils.PageUtils;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDomainServiceImpl implements UserDomainService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

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
        userMapper.insertOrUpdate(userDO);
        //保存用户角色
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userDO.getId());
        List<UserRoleDO> userRoleDOS = userRoleMapper.selectListByQuery(queryWrapper);
        List<Long> roleIds = userRoleDOS.stream().map(UserRoleDO::getRoleId).collect(Collectors.toList());
        List<Long> newRoleIds = userDomain.getRoles().stream()
                .map(RoleDomain::getId)
                .collect(Collectors.toList());
        Collection<Long> deleteRoleIds = CollectionUtil.subtract(roleIds, newRoleIds);
        Collection<Long> addRoleIds = CollectionUtil.subtract(newRoleIds, roleIds);
        List<UserRoleDO> addUserRoleList = addRoleIds.stream().map(e -> {
            UserRoleDO userRoleDO = new UserRoleDO();
            userRoleDO.setUserId(userDO.getId());
            userRoleDO.setRoleId(e);
            return userRoleDO;
        }).collect(Collectors.toList());
        userRoleMapper.insertBatch(addUserRoleList);
        userRoleMapper.deleteBatchByIds(deleteRoleIds);
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
