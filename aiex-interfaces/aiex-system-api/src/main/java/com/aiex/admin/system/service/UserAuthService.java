package com.aiex.admin.system.service;

import com.aiex.admin.system.dto.GenRoleDTO;
import com.aiex.admin.system.dto.UserAuthDTO;

public interface UserAuthService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserAuthDTO getById(Long id);

    /**
     * 保存用户与角色信息
     * @param userAuthDTO
     */
    void save(UserAuthDTO userAuthDTO);

    /**
     * 分配角色
     * @param genRoleDTO
     */
    void genRole(GenRoleDTO genRoleDTO);
}
