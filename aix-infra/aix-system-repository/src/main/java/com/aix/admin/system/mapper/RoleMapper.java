package com.aix.admin.system.mapper;

import com.aix.admin.system.entity.Role;
import com.aix.admin.system.entity.table.UserTableDef;
import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.List;

import static com.aix.admin.system.entity.table.UserTableDef.USER;

public interface RoleMapper extends BaseMapper<Role> {


    default List<Role> selectListByUserId(Long userId){
        return this.selectListByQuery(QueryWrapper.create()
                .select()
                .from("sys_user_role").as("ur")
                .leftJoin("sys_role").as("r").on("ur.role_id = r.id")
                .where("ur.user_id = ?", userId));
    };
}
