package com.zhao.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.zhao.vhr.mapper")
@EnableCaching
public class VhrTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrTestApplication.class, args);
    }

}
