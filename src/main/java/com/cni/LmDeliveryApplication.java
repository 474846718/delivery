package com.cni;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cni.mapper")    //对mapper扫描
public class LmDeliveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LmDeliveryApplication.class, args);
    }
}