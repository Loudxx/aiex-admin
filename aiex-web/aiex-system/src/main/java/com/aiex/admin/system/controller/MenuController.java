package com.aiex.admin.system.controller;

import com.aiex.admin.system.dto.MenuDTO;
import com.aiex.admin.system.dto.query.MenuQueryDTO;
import com.aiex.admin.system.service.MenuService;
import com.aiex.framework.web.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/listTreeByQuery")
    public Result<List<MenuDTO>> listTreeByQuery(@RequestBody MenuQueryDTO menuQueryDTO){
       List<MenuDTO> menuDTOList = menuService.listTreeByQuery(menuQueryDTO);
        return Result.ok(menuDTOList);
    }

    @PostMapping("/listByQuery")
    public Result<List<MenuDTO>> listByQuery(@RequestBody MenuQueryDTO menuQueryDTO){
        List<MenuDTO> menuDTOList = menuService.listByQuery(menuQueryDTO);
        return Result.ok(menuDTOList);
    }

    @PostMapping("/save")
    public Result<Void> save(@RequestBody MenuDTO menuDTO){
        menuService.save(menuDTO);
        return Result.ok();
    }

    @GetMapping("/{id}")
    public Result<MenuDTO> getById(@RequestParam("id") Long id){
        MenuDTO menuDTO = menuService.getById(id);
        return Result.ok(menuDTO);
    }

    @DeleteMapping("/{ids}")
    public Result<Void> delete(@PathVariable("ids") List<Long> ids){
        menuService.deleteByIds(ids);
        return Result.ok();
    }


}
