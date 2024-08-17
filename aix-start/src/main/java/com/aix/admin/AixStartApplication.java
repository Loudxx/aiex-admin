package com.aix.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aix.admin.*.mapper")
public class AixStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AixStartApplication.class, args);
    }

}
