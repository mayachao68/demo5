package com.bawie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.bawie.mapper")
public class TestAPP {
    public static void main(String[] args) {
        SpringApplication.run(TestAPP.class,args);
    }
}
