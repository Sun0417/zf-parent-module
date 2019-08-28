package com.zf.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zf"})
@EnableJpaRepositories(value = {"com.zf.dao"})
@EntityScan(value = {"com.zf.dao.entity"})
public class WebApplication {
    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class, args);
    }

}
