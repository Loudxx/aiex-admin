package com.aix.admin.system.entity.query;

import com.aix.framework.db.config.base.PageDTO;
import lombok.Data;

@Data
public class RoleQueryDO extends PageDTO<RoleQueryDO> {

    private String name;

}
