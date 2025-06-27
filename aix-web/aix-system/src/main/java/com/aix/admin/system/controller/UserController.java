package com.aix.admin.system.controller;

import com.aix.admin.system.dto.UserAuthDTO;
import com.aix.admin.system.dto.UserDTO;
import com.aix.admin.system.dto.query.UserQueryDTO;
import com.aix.admin.system.service.UserAuthService;
import com.aix.admin.system.service.UserService;
import com.aix.framework.db.config.base.PageDTO;
import com.aix.framework.web.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/pageByQuery")
    public Result<PageDTO<UserDTO>> pageByQuery(@RequestBody UserQueryDTO userQueryDTO){
        PageDTO<UserDTO> pageDTO = userService.pageByQuery(userQueryDTO);
        return Result.ok(pageDTO);
    }

    @PostMapping("/save")
    public Result<Void> save(@RequestBody UserAuthDTO userAuthDTO){
        userAuthService.save(userAuthDTO);
        return Result.ok();
    }

    @GetMapping("/{id}")
    public Result<UserAuthDTO> getById(@PathVariable("id") Long id){
        UserAuthDTO userAuthDTO = userAuthService.getById(id);
        return Result.ok(userAuthDTO);
    }

    @DeleteMapping("/{ids}")
    public Result<Void> delete(@PathVariable("ids") List<Long> ids){
        userService.deleteByIds(ids);
        return Result.ok();
    }




}
