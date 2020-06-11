package com.test.RedisDemo;

import com.test.RedisDemo.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(value = "com.test")
public class HelloworldApplication {

    @Autowired
    static RedisService redisService;

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);

        redisService.saveObject("test1","test555");

    }

}

