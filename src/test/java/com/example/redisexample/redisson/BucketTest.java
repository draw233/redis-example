package com.example.redisexample.redisson;

import com.example.redisexample.RedisExampleApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.DeletedObjectListener;
import org.redisson.api.ObjectListener;
import org.redisson.api.RBucket;
import org.redisson.api.RFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author mirau on 2022/2/21.
 * @version 1.0
 */
public class BucketTest extends RedisExampleApplicationTests {

    @Test
    public void addDataTest() {

        RBucket<String> bucket = redissonClient.getBucket("foo");
        // set data
        bucket.set("bar");

        // getAndSet
        bucket.getAndSet("bar2", 10L, TimeUnit.HOURS);
        RFuture<Integer> name_del = bucket.addListenerAsync(new DeletedObjectListener() {
            @Override
            public void onDeleted(String name) {
                System.out.println("name del");
            }
        });

        try {
            name_del.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
