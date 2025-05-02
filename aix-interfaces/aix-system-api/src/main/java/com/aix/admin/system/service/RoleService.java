package com.aix.admin.system.service;

import com.aix.admin.system.dto.RoleDTO;
import com.aix.admin.system.dto.query.RoleQueryDTO;
import com.aix.framework.db.config.base.PageDTO;

import java.util.List;

public interface RoleService {
    /**
     * 分页查询
     * @param roleQueryDTO
     * @return
     */
    PageDTO<RoleDTO> pageByQuery(RoleQueryDTO roleQueryDTO);

    /**
     * 保存
     * @param roleDTO
     */
    void save(RoleDTO roleDTO);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    RoleDTO getById(Long id);

    /**
     * 根据ids删除
     * @param ids
     * @return
     */
    void deleteByIds(List<Long> ids);
}
