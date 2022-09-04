package com.ABCShop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ABCshop.mapper")
@SpringBootApplication
public class StartABCShop {

    public static void main(String[] args) {
        SpringApplication.run(StartABCShop.class, args);
    }



}
