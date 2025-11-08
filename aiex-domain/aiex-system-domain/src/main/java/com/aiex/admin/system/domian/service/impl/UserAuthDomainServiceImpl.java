package com.aiex.admin.system.domian.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.aiex.admin.system.domian.domain.GenRoleDomain;
import com.aiex.admin.system.domian.domain.MenuDomain;
import com.aiex.admin.system.domian.domain.RoleDomain;
import com.aiex.admin.system.domian.domain.UserAuthDomain;
import com.aiex.admin.system.domian.service.UserAuthDomainService;
import com.aiex.admin.system.entity.MenuDO;
import com.aiex.admin.system.entity.RoleDO;
import com.aiex.admin.system.entity.UserDO;
import com.aiex.admin.system.entity.UserRoleDO;
import com.aiex.admin.system.entity.query.UserMenuQueryDO;
import com.aiex.admin.system.mapper.MenuMapper;
import com.aiex.admin.system.mapper.RoleMapper;
import com.aiex.admin.system.mapper.UserMapper;
import com.aiex.admin.system.mapper.UserRoleMapper;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserAuthDomainServiceImpl implements UserAuthDomainService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserAuthDomain getByUserName(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        UserDO user = userMapper.selectOneByQuery(queryWrapper);
        return buildUserDomain(user);
    }

    private UserAuthDomain buildUserDomain(UserDO user) {
        if(Objects.isNull(user)){
            return null;
        }
        UserAuthDomain userDomain = BeanUtil.toBean(user, UserAuthDomain.class);
        //查询用户对应角色
        List<RoleDO> roleDOList = roleMapper.selectListByUserId(user.getId());
        List<RoleDomain> roles = BeanUtil.copyToList(roleDOList, RoleDomain.class);
        //查询用户对应菜单
        UserMenuQueryDO userMenuQueryDO = new UserMenuQueryDO();
        userMenuQueryDO.setUserId(user.getId());
        List<MenuDO> menuDOList = menuMapper.listUserByQuery(userMenuQueryDO);
        List<MenuDomain> menus = BeanUtil.copyToList(menuDOList, MenuDomain.class);
        userDomain.setRoles(roles);
        userDomain.setMenus(menus);
        return userDomain;
    }

    @Override
    public UserAuthDomain getById(Long id) {
        UserDO userDO = userMapper.selectOneById(id);
        return buildUserDomain(userDO);
    }

    @Override
    public void save(UserAuthDomain userAuthDomain) {
        UserDO userDO = BeanUtil.toBean(userAuthDomain, UserDO.class);
        //保存用户
        userMapper.insertOrUpdateSelective(userDO);

    }

    @Override
    public void genRole(GenRoleDomain genRoleDomain) {
        //保存用户角色
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", genRoleDomain.getId());
        List<UserRoleDO> userRoleDOS = userRoleMapper.selectListByQuery(queryWrapper);
        List<Long> roleIds = userRoleDOS.stream().map(UserRoleDO::getRoleId).collect(Collectors.toList());
        List<Long> newRoleIds = genRoleDomain.getRoleIds();
        Collection<Long> deleteRoleIds = CollectionUtil.subtract(roleIds, newRoleIds);
        Collection<Long> addRoleIds = CollectionUtil.subtract(newRoleIds, roleIds);
        List<UserRoleDO> addUserRoleList = addRoleIds.stream().map(e -> {
            UserRoleDO userRoleDO = new UserRoleDO();
            userRoleDO.setUserId(genRoleDomain.getId());
            userRoleDO.setRoleId(e);
            return userRoleDO;
        }).collect(Collectors.toList());
        if(CollectionUtil.isNotEmpty(addUserRoleList)){
            userRoleMapper.insertBatch(addUserRoleList);
        }
        if(CollectionUtil.isNotEmpty(deleteRoleIds)){
            userRoleMapper.deleteByUserIdAndRoleList(genRoleDomain.getId(), deleteRoleIds);
        }
    }
}
