package com.aix.admin.system.controller;

import com.aix.admin.system.dto.MenuDTO;
import com.aix.admin.system.entity.MenuDO;
import com.aix.admin.system.entity.UserDO;
import com.aix.admin.system.service.MenuService;
import com.aix.framework.core.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取当前登录用户信息
     * @return User
     */
    @GetMapping("/getUserMenu")
    public Result<List<MenuDTO>> getUserMenu(){
        UserDO user = (UserDO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<MenuDTO> menuDTOList = menuService.listTreeByUserId(user.getId());
        return Result.ok(menuDTOList);
    }



}
