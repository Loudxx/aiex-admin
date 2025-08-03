package com.aix.admin.system.domian.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aix.admin.system.domian.domain.RoleDomain;
import com.aix.admin.system.domian.domain.query.RoleQueryDomain;
import com.aix.admin.system.domian.service.RoleDomainService;
import com.aix.admin.system.entity.RoleDO;
import com.aix.admin.system.entity.query.RoleQueryDO;
import com.aix.admin.system.mapper.RoleMapper;
import com.aix.framework.db.config.base.PageDTO;
import com.aix.framework.db.config.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleDomainServiceImpl implements RoleDomainService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageDTO<RoleDomain> pageByQuery(RoleQueryDomain queryDomain) {
        RoleQueryDO roleQueryDO = BeanUtil.toBean(queryDomain, RoleQueryDO.class);
        PageDTO<RoleDO> pageDTO = roleMapper.pageByQuery(roleQueryDO);
        return PageUtils.copy(pageDTO, RoleDomain.class);
    }

    @Override
    public void save(RoleDomain roleDomain) {
        RoleDO roleDO = BeanUtil.toBean(roleDomain, RoleDO.class);
        roleMapper.insertOrUpdate(roleDO);
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
}
