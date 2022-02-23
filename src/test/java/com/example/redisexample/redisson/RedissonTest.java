package com.example.redisexample.redisson;

import com.example.redisexample.RedisExampleApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author mirau on 2022/2/21.
 * @version 1.0
 */
public class RedissonTest extends RedisExampleApplicationTests {

    @Autowired
    @Qualifier("redisson")
    private RedissonClient redissonClient;

    @Test
    public void setTest() {
        redissonClient.getBucket("bb").set("bbb");
    }
}
