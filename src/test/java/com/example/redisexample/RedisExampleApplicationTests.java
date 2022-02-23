package com.example.redisexample;

import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisExampleApplicationTests {

    @Autowired
    @Qualifier("redisson")
    public RedissonClient redissonClient;

    @Test
    void contextLoads() {
    }

}
