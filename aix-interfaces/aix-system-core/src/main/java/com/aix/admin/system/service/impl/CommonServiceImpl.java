package com.aix.admin.system.service.impl;

import com.aix.admin.system.domian.service.CommonDomainService;
import com.aix.admin.system.service.CommonService;
import com.aix.framework.core.base.dto.EnumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDomainService commonDomainService;


    @Override
    public Map<String, List<EnumDTO>> getDict(List<String> dictNameList) {
        return commonDomainService.getDict(dictNameList);
    }

    @Override
    public Map<String, List<EnumDTO>> getAllDict() {
        return commonDomainService.getAllDict();
    }
}
