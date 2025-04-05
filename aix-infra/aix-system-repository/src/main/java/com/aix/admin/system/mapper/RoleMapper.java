package com.aix.admin.system.mapper;

import com.aix.admin.system.entity.RoleDO;
import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.List;

public interface RoleMapper extends BaseMapper<RoleDO> {


    default List<RoleDO> selectListByUserId(Long userId){
        return this.selectListByQuery(QueryWrapper.create()
                .select()
                .from("sys_user_role").as("ur")
                .leftJoin("sys_role").as("r").on("ur.role_id = r.id")
                .where("ur.user_id = ?", userId));
    };
}
