package com.taoge.zxstbg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.taoge.zxstbg")
public class ZxstbgApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZxstbgApplication.class, args);
    }

}

