package com.aix.admin.system.mapper;

import cn.hutool.core.util.ObjectUtil;
import com.aix.admin.system.entity.MenuDO;
import com.aix.admin.system.entity.query.MenuQueryDO;
import com.aix.admin.system.entity.query.UserMenuQueryDO;
import com.aix.framework.db.config.base.mapper.FlexBaseMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.List;

import static com.aix.admin.system.entity.table.MenuDOTableDef.MENU_DO;
import static com.aix.admin.system.entity.table.RoleDOTableDef.ROLE_DO;
import static com.aix.admin.system.entity.table.RoleMenuDOTableDef.ROLE_MENU_DO;
import static com.aix.admin.system.entity.table.UserRoleDOTableDef.USER_ROLE_DO;

public interface MenuMapper extends FlexBaseMapper<MenuDO> {

    /**
     * 根据条件查询菜单
     * @param menuQueryDO
     * @return
     */
    default List<MenuDO> listByQuery(MenuQueryDO menuQueryDO){
        return this.selectListByQuery(QueryWrapper.create()
                .select()
                .from(MENU_DO));
    }

    default List<MenuDO> listUserByQuery(UserMenuQueryDO userMenuQueryDO){
        return this.selectListByQuery(QueryWrapper.create()
                .select(MENU_DO.DEFAULT_COLUMNS)
                .from(USER_ROLE_DO)
                .leftJoin(ROLE_DO).on(USER_ROLE_DO.ROLE_ID.eq(ROLE_DO.ID))
                .leftJoin(ROLE_MENU_DO).on(ROLE_DO.ID.eq(ROLE_MENU_DO.ROLE_ID))
                .leftJoin(MENU_DO).on(ROLE_MENU_DO.MENU_ID.eq(MENU_DO.ID))
                .where(USER_ROLE_DO.USER_ID.eq(userMenuQueryDO.getUserId(), ObjectUtil::isNotEmpty)));
    };
}
