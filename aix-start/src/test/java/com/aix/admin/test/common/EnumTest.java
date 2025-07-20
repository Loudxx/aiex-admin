package com.aix.admin.test.common;

import com.aix.framework.core.base.dto.EnumDTO;
import com.aix.framework.core.utils.EnumUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class EnumTest {

    @Test
    public void getEnums() throws InvocationTargetException, IllegalAccessException {
        String packageName = "com.aix.admin.common.enums";
        Map<String, List<EnumDTO>> enums = EnumUtils.getEnums(packageName);
        System.out.println(enums);
    }



}
