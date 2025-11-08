package com.aiex.admin.system.service;

import com.aiex.framework.core.base.dto.EnumDTO;

import java.util.List;
import java.util.Map;

public interface CommonService {
    /**
     * 根据多个字典名称查询
     * @param dictNameList
     * @return
     */
    Map<String, List<EnumDTO>> getDict(List<String> dictNameList);

    /**
     * 获取所有字典数据
     * @return
     */
    Map<String, List<EnumDTO>> getAllDict();
}
