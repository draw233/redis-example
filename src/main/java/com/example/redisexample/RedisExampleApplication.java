package com.example.redisexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@Slf4j
public class RedisExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisExampleApplication.class, args);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LOGGER.info("测试定时任务{}", LocalDateTime.now());
            }
        }, 1, 60_000L);
    }

}
