package com.aiex.admin.system.entity.query;

import com.aiex.framework.db.config.base.PageDTO;
import lombok.Data;

@Data
public class RoleQueryDO extends PageDTO<RoleQueryDO> {

    private String name;

    private String code;

    private String status;

}
