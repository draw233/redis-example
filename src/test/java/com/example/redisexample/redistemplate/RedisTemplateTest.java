package com.example.redisexample.redistemplate;

import com.example.redisexample.RedisExampleApplicationTests;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mirau on 2022/2/23.
 * @version 1.0
 */
public class RedisTemplateTest extends RedisExampleApplicationTests {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void testSet() {
        redisTemplate.opsForValue().set("k11", "bbb");
    }

    List<Person> list = new ArrayList<>();

    @BeforeEach
    public void data() {
        for (int i = 0; i < 100; i++) {
            list.add(new Person("name" + i));
        }
    }

    @Test
    public void testSetObj() {
        redisTemplate.opsForValue().set("k11", list);
    }

    @Test
    public void testGetObj() {
        List<Person> k11 = (List<Person>) redisTemplate.opsForValue().get("k11");
        assert k11 != null;
        k11.forEach(System.out::println);
    }

    @AllArgsConstructor
    @Data
    static class Person implements Serializable {
        private String name;
    }
}
