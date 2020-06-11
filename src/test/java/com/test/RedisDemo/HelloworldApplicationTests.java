package com.test.RedisDemo;

import com.test.RedisDemo.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloworldApplicationTests {

    @Autowired
    RedisService iRedisService;

    @Test
    public void testCache() {

        iRedisService.saveObject("test4key3","test");

        iRedisService.saveObject("age",12);

        boolean existed = iRedisService.hasKey("age");
        System.out.println(existed);

        String object = iRedisService.get("age",String.class);
        System.out.println(object);

    }

}
