package com.aix.admin.system.mapper;

import cn.hutool.core.util.ObjectUtil;
import com.aix.admin.system.entity.UserDO;
import com.aix.admin.system.entity.query.UserQueryDO;
import com.aix.framework.db.config.base.PageDTO;
import com.aix.framework.db.config.base.mapper.FlexBaseMapper;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

import static com.aix.admin.system.entity.table.UserDOTableDef.USER_DO;

@Mapper
public interface UserMapper extends FlexBaseMapper<UserDO> {

    default PageDTO<UserDO> pageByQuery(UserQueryDO userQueryPO){
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(USER_DO.USERNAME.likeLeft(userQueryPO.getUsername(), ObjectUtil::isNotEmpty))
                .and(USER_DO.EMAIL.likeLeft(userQueryPO.getUsername(), ObjectUtil::isNotEmpty))
                .and(USER_DO.MOBILE.likeLeft(userQueryPO.getUsername(), ObjectUtil::isNotEmpty))
                .and(USER_DO.STATUS.eq(userQueryPO.getStatus(), ObjectUtil::isNotEmpty));
        return page(userQueryPO.getPageNumber(), userQueryPO.getPageSize(), queryWrapper);
    }
}
