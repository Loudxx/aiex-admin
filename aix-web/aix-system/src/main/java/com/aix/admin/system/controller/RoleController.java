package com.aix.admin.system.controller;

import com.aix.admin.system.dto.RoleDTO;
import com.aix.admin.system.dto.query.RoleQueryDTO;
import com.aix.admin.system.service.RoleService;
import com.aix.framework.db.config.base.PageDTO;
import com.aix.framework.web.base.Result;
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

}
