package com.example.redisexample.redisson;

import com.example.redisexample.RedisExampleApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RBucket;

/**
 * @author mirau on 2022/3/17.
 * @version 1.0
 */
public class BloomFilterExamples extends RedisExampleApplicationTests {

    @Test
    public void t1() {

        RBloomFilter<Object> bloomFilter = redissonClient.getBloomFilter("bloomFilter");

        bloomFilter.tryInit(100_000_000, 0.03);

        System.out.println(bloomFilter.add("a"));
        System.out.println(bloomFilter.add("b"));
        System.out.println(bloomFilter.add("c"));
        System.out.println(bloomFilter.add("d"));

        System.out.println(bloomFilter.getExpectedInsertions());
        System.out.println(bloomFilter.getFalseProbability());
        System.out.println(bloomFilter.getHashIterations());

        System.out.println(bloomFilter.contains("a"));

        System.out.println(bloomFilter.count());


    }
}
