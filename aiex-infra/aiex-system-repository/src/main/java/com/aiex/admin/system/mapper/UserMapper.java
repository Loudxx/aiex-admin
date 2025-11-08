package com.aiex.admin.system.mapper;

import com.aiex.admin.system.entity.UserDO;
import com.aiex.admin.system.entity.query.UserQueryDO;
import com.aiex.framework.db.config.base.PageDTO;
import com.aiex.framework.db.config.base.mapper.FlexBaseMapper;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

import static com.aiex.admin.system.entity.table.UserDOTableDef.USER_DO;

@Mapper
public interface UserMapper extends FlexBaseMapper<UserDO> {

    default PageDTO<UserDO> pageByQuery(UserQueryDO userQueryPO){
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(USER_DO.USERNAME.likeLeft(userQueryPO.getUsername()))
                .and(USER_DO.EMAIL.likeLeft(userQueryPO.getEmail()))
                .and(USER_DO.MOBILE.likeLeft(userQueryPO.getMobile()))
                .and(USER_DO.STATUS.eq(userQueryPO.getStatus()))
                .and(USER_DO.CREATE_TIME.between(userQueryPO.getCreateTimeStart(), userQueryPO.getCreateTimeEnd()));
        return page(userQueryPO.getPageNumber(), userQueryPO.getPageSize(), queryWrapper);
    }
}
