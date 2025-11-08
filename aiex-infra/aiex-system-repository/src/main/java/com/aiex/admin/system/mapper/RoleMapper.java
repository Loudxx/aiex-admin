package com.aiex.admin.system.mapper;

import cn.hutool.core.util.ObjectUtil;
import com.aiex.admin.system.entity.RoleDO;
import com.aiex.admin.system.entity.query.RoleQueryDO;
import com.aiex.framework.db.config.base.PageDTO;
import com.aiex.framework.db.config.base.mapper.FlexBaseMapper;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.List;

import static com.aiex.admin.system.entity.table.RoleDOTableDef.ROLE_DO;

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
                .where(ROLE_DO.NAME.likeLeft(roleQueryDO.getName(), ObjectUtil::isNotEmpty))
                .and(ROLE_DO.CODE.likeLeft(roleQueryDO.getCode(), ObjectUtil::isNotEmpty))
                .and(ROLE_DO.STATUS.eq(roleQueryDO.getStatus(), ObjectUtil::isNotEmpty));
        return page(roleQueryDO.getPageNumber(), roleQueryDO.getPageSize(), queryWrapper);
    }

    default List<RoleDO> listByQuery(RoleQueryDO roleQueryDO){
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(ROLE_DO.NAME.likeLeft(roleQueryDO.getName(), ObjectUtil::isNotEmpty))
                .and(ROLE_DO.CODE.likeLeft(roleQueryDO.getCode(), ObjectUtil::isNotEmpty))
                .and(ROLE_DO.STATUS.eq(roleQueryDO.getStatus(), ObjectUtil::isNotEmpty));
        return selectListByQuery(queryWrapper);
    }

}
