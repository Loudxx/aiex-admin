package com.aix.admin.system.mapper;

import com.aix.admin.system.entity.Menu;
import com.aix.admin.system.entity.Role;
import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户查询菜单
     * @param userId
     * @return
     */
    default List<Menu> selectListByUserId(Long userId){
        return this.selectListByQuery(QueryWrapper.create()
                .select()
                .from("sys_user_role").as("ur")
                .leftJoin("sys_role").as("r").on("ur.role_id = r.id")
                .leftJoin("sys_role_menu").as("rm").on("r.id = rm.role_id")
                .leftJoin("sys_menu").as("m").on("rm.menu_id = m.id")
                .where("ur.user_id = ?", userId));
    };
}
