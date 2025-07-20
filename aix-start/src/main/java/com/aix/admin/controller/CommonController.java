package com.aix.admin.controller;

import com.aix.admin.system.dto.MenuDTO;
import com.aix.framework.web.base.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {

    @GetMapping("/{id}")
    public Result<MenuDTO> getById(@RequestParam("id") Long id){
        return Result.ok();
    }


}
