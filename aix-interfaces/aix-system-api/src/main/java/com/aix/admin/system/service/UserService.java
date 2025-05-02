package com.aix.admin.system.service;

import com.aix.admin.system.dto.UserDTO;
import com.aix.admin.system.dto.query.UserQueryDTO;
import com.aix.framework.db.config.base.PageDTO;

import java.util.List;

public interface UserService {
    /**
     * 分页查询
     * @param userQueryDTO 查询参数
     * @return
     */
    PageDTO<UserDTO> pageByQuery(UserQueryDTO userQueryDTO);

    /**
     * 保存
     * @param userDTO 用户信息
     */
    void save(UserDTO userDTO);

    /**
     * 根据id查询
     * @param id 主键
     * @return UserDTO
     */
    UserDTO getById(Long id);

    /**
     * 根据多个id删除
     * @param ids
     */
    void deleteByIds(List<Long> ids);
}
