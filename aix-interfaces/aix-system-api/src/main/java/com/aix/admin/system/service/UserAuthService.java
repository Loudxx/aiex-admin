package com.aix.admin.system.service;

import com.aix.admin.system.dto.UserAuthDTO;
import com.aix.admin.system.dto.UserDTO;

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
}
