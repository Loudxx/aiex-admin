package com.aix.admin.system.service;

import com.aix.admin.system.dto.MenuDTO;
import com.aix.admin.system.dto.query.MenuQueryDTO;
import com.aix.admin.system.dto.query.UserMenuQueryDTO;
import com.aix.framework.db.config.base.PageDTO;

import java.util.List;

public interface MenuService {
    /**
     * 查询树级菜单
     * @return
     */
    List<MenuDTO> listTreeByQuery(MenuQueryDTO menuQueryDTO);

    /**
     * 保存
     * @param menuDTO
     */
    void save(MenuDTO menuDTO);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    MenuDTO getById(Long id);

    /**
     * 根据ids删除
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 查询用户的权限
     * @param userMenuQueryDTO
     * @return
     */
    List<MenuDTO> listUserTreeByQuery(UserMenuQueryDTO userMenuQueryDTO);

    /**
     * 查询菜单列表
     * @param menuQueryDTO
     * @return
     */
    List<MenuDTO> listByQuery(MenuQueryDTO menuQueryDTO);
}
