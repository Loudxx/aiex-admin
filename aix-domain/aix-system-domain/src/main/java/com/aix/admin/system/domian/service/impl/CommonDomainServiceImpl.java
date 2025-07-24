package com.aix.admin.system.domian.service.impl;

import com.aix.admin.system.domian.service.CommonDomainService;
import com.aix.framework.core.base.dto.EnumDTO;
import com.aix.framework.core.utils.EnumUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonDomainServiceImpl implements CommonDomainService {

    public static final Map<String, List<EnumDTO>> DICT_MAP = new HashMap<>();

    static {
        String packageName = "com.aix.admin.common.enums";
        try {
            DICT_MAP.putAll(EnumUtils.getEnums(packageName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Map<String, List<EnumDTO>> getDict(List<String> dictNameList) {
        Map<String, List<EnumDTO>> dictMap = new HashMap<>();
        for (String dictName : dictNameList) {
            dictMap.put(dictName, DICT_MAP.get(dictName));
        }
        return dictMap;
    }

    @Override
    public Map<String, List<EnumDTO>> getAllDict() {
        return DICT_MAP;
    }
}
