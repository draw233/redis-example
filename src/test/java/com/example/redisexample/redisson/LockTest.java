package com.example.redisexample.redisson;

import com.example.redisexample.RedisExampleApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author mirau on 2022/2/21.
 * @version 1.0
 */
public class LockTest extends RedisExampleApplicationTests {

    @Test
    public void addLockTest() {
        RLock myLock = redissonClient.getLock("myLock");
        try {
            // 尝试10秒内获取锁，获取锁成功之后100秒释放锁
            boolean b = myLock.tryLock(10, 100, TimeUnit.SECONDS);
            if (b) {
                try {
                    System.out.println("获取锁成功");
                } finally {
                    myLock.unlock();
                }
            } else {
                System.out.println("获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addLockTest2() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                RLock myLock = redissonClient.getLock("myLock");
                try {
                    if (myLock.tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            System.out.println(Thread.currentThread().getId() + finalI + "获取锁成功");
                            // 模拟业务耗时
                            TimeUnit.SECONDS.sleep(5L);
                        } finally {
                            myLock.unlock();
                            System.out.println(Thread.currentThread().getId() + finalI + "释放锁");
                        }
                    } else {
                        System.out.println(Thread.currentThread().getId() + finalI + "获取锁失败");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        latch.await();
    }
}
