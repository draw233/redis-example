package com.example.redisexample.redisson;

import com.example.redisexample.RedisExampleApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;

/**
 * @author mirau on 2022/2/21.
 * @version 1.0
 */
public class SetTest extends RedisExampleApplicationTests {

    @Test
    public void setTest() {
        RSet<Integer> mySet = redissonClient.getSet("mySet");
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        Set<Integer> integers = mySet.readAll();
        integers.forEach(System.out::println);
    }
}
