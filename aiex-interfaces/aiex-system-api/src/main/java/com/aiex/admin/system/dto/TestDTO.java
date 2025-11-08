package com.aiex.admin.system.dto;

import com.aiex.framework.core.base.dto.BaseDTO;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
public class TestDTO extends BaseDTO {

    @Id(keyType = KeyType.Auto)
    private Long id;
    private String userName;
    private Integer age;

}