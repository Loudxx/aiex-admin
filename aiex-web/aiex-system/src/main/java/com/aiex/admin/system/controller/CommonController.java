package com.aiex.admin.system.controller;

import com.aiex.admin.system.service.CommonService;
import com.aiex.framework.core.base.dto.EnumDTO;
import com.aiex.framework.web.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("system/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @GetMapping("/getAllDict")
    public Result<Map<String, List<EnumDTO>>> getAllDict(){
        Map<String, List<EnumDTO>> dictMap = commonService.getAllDict();
        return Result.ok(dictMap);
    }

    @GetMapping("/getDict")
    public Result<Map<String, List<EnumDTO>>> getDict(@RequestParam("dictNameList") List<String> dictNameList){
        Map<String, List<EnumDTO>> dictMap = commonService.getDict(dictNameList);
        return Result.ok(dictMap);
    }


}
