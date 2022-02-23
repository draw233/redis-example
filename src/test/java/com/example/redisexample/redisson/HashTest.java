package com.example.redisexample.redisson;

import com.example.redisexample.RedisExampleApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.RMap;
import org.redisson.api.RSet;

/**
 * @author mirau on 2022/2/21.
 * @version 1.0
 */
public class HashTest extends RedisExampleApplicationTests {

    @Test
    public void setTest() {
        RMap<Object, Object> myHash = redissonClient.getMap("myHash");

        for (int i = 0; i < 511; i++) {
            myHash.put("k" + i, "v" + 1);
        }

    }

    @Test
    public void hashTest2() {
        RMap<Object, Object> myHash = redissonClient.getMap("myHash");
            myHash.put("k" + 992, "v" + 991);
    }
}
