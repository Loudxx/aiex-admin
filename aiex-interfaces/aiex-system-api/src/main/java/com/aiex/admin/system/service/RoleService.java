package com.aiex.admin.system.service;

import com.aiex.admin.system.dto.GenAuthDTO;
import com.aiex.admin.system.dto.RoleDTO;
import com.aiex.admin.system.dto.RoleStatusDTO;
import com.aiex.admin.system.dto.query.RoleQueryDTO;
import com.aiex.framework.db.config.base.PageDTO;

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

    /**
     * 条件查询
     * @param roleQueryDTO
     * @return
     */
    List<RoleDTO> listByQuery(RoleQueryDTO roleQueryDTO);

    /**
     * 修改状态
     * @param roleStatusDTO
     */
    void updateStatus(RoleStatusDTO roleStatusDTO);

    /**
     * 分配权限
     * @param genAuthDTO
     */
    void genAuth(GenAuthDTO genAuthDTO);

    /**
     * 获取详情
     * @param id
     * @return
     */
    List<Long> genAuthDetail(Long id);
}
