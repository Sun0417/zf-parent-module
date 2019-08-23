package com.zf.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ZfModuleWebApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZfModuleWebApiApplication.class, args);
    }

}
