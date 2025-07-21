package com.aix.admin.system.domian.service;

import com.aix.framework.core.base.dto.EnumDTO;

import java.util.List;
import java.util.Map;

public interface CommonDomainService {
    /**
     * 根据多个字典名称查询
     * @param dictNameList
     * @return
     */
    Map<String, List<EnumDTO>> getDict(List<String> dictNameList);
}
