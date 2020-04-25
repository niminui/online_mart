package com.nmh.online_mart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nmh.online_mart.mapper")
public class OnlineMartApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineMartApplication.class, args);
    }

}
