package com.aiex.admin.test.common;

import com.aiex.framework.core.base.dto.EnumDTO;
import com.aiex.framework.core.utils.EnumUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class EnumTest {

    @Test
    public void getEnums() throws InvocationTargetException, IllegalAccessException {
        String packageName = "com.aiex.admin.common.enums";
        Map<String, List<EnumDTO>> enums = EnumUtils.getEnums(packageName);
        System.out.println(enums);
    }



}
