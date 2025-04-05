package com.aix.admin.system.service;

import com.aix.admin.system.dto.MenuDTO;

import java.util.List;

public interface MenuService {
    /**
     * 根据
     * @param userId
     * @return
     */
    List<MenuDTO> listTreeByUserId(Long userId);

    /**
     * 查询全部
     * @return
     */
    List<MenuDTO> selectAll();
}
