package com.aiex.admin.system.domian.service.impl;

import com.aiex.admin.system.domian.service.CommonDomainService;
import com.aiex.framework.core.base.dto.EnumDTO;
import com.aiex.framework.core.utils.EnumUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonDomainServiceImpl implements CommonDomainService {

    public static final Map<String, List<EnumDTO>> DICT_MAP = new HashMap<>();

    static {
        String packageName = "com.aiex.admin.common.enums";
        try {
            Map<String, List<EnumDTO>> enums = EnumUtils.getEnums(packageName);
            enums.forEach((key, value)->{
                DICT_MAP.put(key.replaceAll("Enum", ""), value);
            });
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
