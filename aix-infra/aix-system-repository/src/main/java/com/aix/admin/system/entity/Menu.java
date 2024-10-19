package com.aix.admin.system.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("sys_menu")
public class Menu {

    @Id(keyType = KeyType.Auto)
    private Long id;

}
