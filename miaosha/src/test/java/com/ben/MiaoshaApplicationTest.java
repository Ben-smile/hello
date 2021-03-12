package com.ben;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class MiaoshaApplicationTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void test01(){
        System.out.println(redisTemplate.opsForValue().get("user"));
    }


}
