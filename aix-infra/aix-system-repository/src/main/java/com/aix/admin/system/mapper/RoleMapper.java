package com.aix.admin.system.mapper;

import cn.hutool.core.util.ObjectUtil;
import com.aix.admin.system.entity.RoleDO;
import com.aix.admin.system.entity.query.RoleQueryDO;
import com.aix.framework.db.config.base.PageDTO;
import com.aix.framework.db.config.base.mapper.FlexBaseMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.List;

import static com.aix.admin.system.entity.table.RoleDOTableDef.ROLE_DO;

public interface RoleMapper extends FlexBaseMapper<RoleDO> {


    default List<RoleDO> selectListByUserId(Long userId){
        return this.selectListByQuery(QueryWrapper.create()
                .select()
                .from("sys_user_role").as("ur")
                .leftJoin("sys_role").as("r").on("ur.role_id = r.id")
                .where("ur.user_id = ?", userId));
    };

    default PageDTO<RoleDO> pageByQuery(RoleQueryDO roleQueryDO){
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(ROLE_DO.NAME.likeLeft(roleQueryDO.getName(), ObjectUtil::isNotEmpty));
        return page(roleQueryDO.getPageNumber(), roleQueryDO.getPageSize(), queryWrapper);
    }
}
