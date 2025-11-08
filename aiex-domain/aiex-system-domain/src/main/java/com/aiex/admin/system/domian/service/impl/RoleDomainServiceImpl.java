package com.aiex.admin.system.domian.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.aiex.admin.system.domian.domain.GenAuthDomain;
import com.aiex.admin.system.domian.domain.RoleDomain;
import com.aiex.admin.system.domian.domain.RoleStatusDomain;
import com.aiex.admin.system.domian.domain.query.RoleQueryDomain;
import com.aiex.admin.system.domian.service.RoleDomainService;
import com.aiex.admin.system.entity.RoleDO;
import com.aiex.admin.system.entity.RoleMenuDO;
import com.aiex.admin.system.entity.query.RoleQueryDO;
import com.aiex.admin.system.mapper.RoleMapper;
import com.aiex.admin.system.mapper.RoleMenuMapper;
import com.aiex.framework.db.config.base.PageDTO;
import com.aiex.framework.db.config.utils.PageUtils;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleDomainServiceImpl implements RoleDomainService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;


    @Override
    public PageDTO<RoleDomain> pageByQuery(RoleQueryDomain queryDomain) {
        RoleQueryDO roleQueryDO = BeanUtil.toBean(queryDomain, RoleQueryDO.class);
        PageDTO<RoleDO> pageDTO = roleMapper.pageByQuery(roleQueryDO);
        return PageUtils.copy(pageDTO, RoleDomain.class);
    }

    @Override
    public void save(RoleDomain roleDomain) {
        RoleDO roleDO = BeanUtil.toBean(roleDomain, RoleDO.class);
        roleMapper.insertOrUpdateSelective(roleDO);
    }

    @Override
    public RoleDomain getById(Long id) {
        RoleDO roleDO = roleMapper.selectOneById(id);
        return BeanUtil.toBean(roleDO, RoleDomain.class);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        roleMapper.deleteBatchByIds(ids);
    }

    @Override
    public List<RoleDomain> listByQuery(RoleQueryDomain queryDomain) {
        RoleQueryDO roleQueryDO = BeanUtil.toBean(queryDomain, RoleQueryDO.class);
        List<RoleDO> roleDOList = roleMapper.listByQuery(roleQueryDO);
        return BeanUtil.copyToList(roleDOList, RoleDomain.class);
    }

    @Override
    public void updateStatus(RoleStatusDomain roleStatusDomain) {
        RoleDO roleDO = new RoleDO();
        roleDO.setId(roleStatusDomain.getRoleId());
        roleDO.setStatus(roleStatusDomain.getStatus());
        roleMapper.update(roleDO, true);
    }

    @Override
    public void genAuth(GenAuthDomain genAuthDomain) {
        //保存用户角色
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", genAuthDomain.getId());
        List<RoleMenuDO> roleMenuDOList = roleMenuMapper.selectListByQuery(queryWrapper);
        List<Long> menuIds = roleMenuDOList.stream().map(RoleMenuDO::getMenuId).collect(Collectors.toList());
        List<Long> newMenuIds = genAuthDomain.getMenuIds();
        Collection<Long> deleteMenuIds = CollectionUtil.subtract(menuIds, newMenuIds);
        Collection<Long> addMenuIds = CollectionUtil.subtract(newMenuIds, menuIds);
        List<RoleMenuDO> addUserRoleList = addMenuIds.stream().map(e -> {
            RoleMenuDO roleMenuDO = new RoleMenuDO();
            roleMenuDO.setRoleId(genAuthDomain.getId());
            roleMenuDO.setMenuId(e);
            return roleMenuDO;
        }).collect(Collectors.toList());
        if(CollectionUtil.isNotEmpty(addUserRoleList)){
            roleMenuMapper.insertBatch(addUserRoleList);
        }
        if(CollectionUtil.isNotEmpty(deleteMenuIds)){
            roleMenuMapper.deleteByRoleIdAndMenuList(genAuthDomain.getId(), deleteMenuIds);
        }
    }

    @Override
    public List<Long> genAuthDetail(Long id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", id);
        List<RoleMenuDO> roleMenuDOList = roleMenuMapper.selectListByQuery(queryWrapper);
        return roleMenuDOList.stream().map(RoleMenuDO::getMenuId).collect(Collectors.toList());
    }
}
