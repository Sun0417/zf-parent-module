package com.zf.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ZfModuleWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZfModuleWebApiApplication.class, args);
    }

    @RequestMapping("web-api/hello")
    public String hello(){
        return "Hello Word";
    }
}
