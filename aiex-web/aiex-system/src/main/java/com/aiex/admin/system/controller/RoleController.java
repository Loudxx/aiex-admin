package com.aiex.admin.system.controller;

import com.aiex.admin.system.dto.*;
import com.aiex.admin.system.dto.query.RoleQueryDTO;
import com.aiex.admin.system.service.RoleService;
import com.aiex.framework.db.config.base.PageDTO;
import com.aiex.framework.web.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/pageByQuery")
    public Result<PageDTO<RoleDTO>> pageByQuery(@RequestBody RoleQueryDTO roleQueryDTO){
        PageDTO<RoleDTO> pageDTO = roleService.pageByQuery(roleQueryDTO);
        return Result.ok(pageDTO);
    }

    @PostMapping("/listByQuery")
    public Result<List<RoleDTO>> listByQuery(@RequestBody RoleQueryDTO roleQueryDTO){
        List<RoleDTO> roleDTOList = roleService.listByQuery(roleQueryDTO);
        return Result.ok(roleDTOList);
    }

    @PostMapping("/save")
    public Result<Void> save(@RequestBody RoleDTO roleDTO){
        roleService.save(roleDTO);
        return Result.ok();
    }

    @GetMapping("/{id}")
    public Result<RoleDTO> getById(@RequestParam("id") Long id){
        RoleDTO roleDTO = roleService.getById(id);
        return Result.ok(roleDTO);
    }

    @DeleteMapping("/{ids}")
    public Result<RoleDTO> delete(@PathVariable("ids") List<Long> ids){
        roleService.deleteByIds(ids);
        return Result.ok();
    }

    @PutMapping("/updateStatus")
    public Result<Void> updateStatus(@RequestBody RoleStatusDTO roleStatusDTO){
        roleService.updateStatus(roleStatusDTO);
        return Result.ok();
    }

    @PutMapping("/genAuth")
    public Result<Void> genAuth(@RequestBody GenAuthDTO genAuthDTO){
        roleService.genAuth(genAuthDTO);
        return Result.ok();
    }

    @GetMapping("/genAuthDetail/{id}")
    public Result<List<Long>> genAuthDetail(@PathVariable("id") Long id){
        List<Long> menuIds = roleService.genAuthDetail(id);
        return Result.ok(menuIds);
    }

}
