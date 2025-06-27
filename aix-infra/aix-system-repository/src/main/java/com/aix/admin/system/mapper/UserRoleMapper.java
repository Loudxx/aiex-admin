package com.aix.admin.system.mapper;

import com.aix.admin.system.entity.UserRoleDO;
import com.aix.framework.db.config.base.mapper.FlexBaseMapper;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface UserRoleMapper extends FlexBaseMapper<UserRoleDO> {

    /**
     * 根据user_id和roleList删除
     * @param userId
     * @param deleteRoleIds
     */
    default void deleteByUserIdAndRoleList(Long userId, Collection<Long> deleteRoleIds){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        queryWrapper.in("role_id", deleteRoleIds);
        deleteByQuery(queryWrapper);
    }
}
