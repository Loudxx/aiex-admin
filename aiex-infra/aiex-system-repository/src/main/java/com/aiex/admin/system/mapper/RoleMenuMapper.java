package com.aiex.admin.system.mapper;

import com.aiex.admin.system.entity.RoleMenuDO;
import com.aiex.framework.db.config.base.mapper.FlexBaseMapper;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface RoleMenuMapper  extends FlexBaseMapper<RoleMenuDO> {


    /**
     * 根据user_id和roleList删除
     * @param userId
     * @param deleteMenuIds
     */
    default void deleteByRoleIdAndMenuList(Long userId, Collection<Long> deleteMenuIds){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", userId);
        queryWrapper.in("menu_id", deleteMenuIds);
        deleteByQuery(queryWrapper);
    }}
