package com.example.redisexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisClientConfig {

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // key采用String的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        // value序列化方式采用  jdkSerializer
        template.setValueSerializer(RedisSerializer.java());
        // hash的value序列化方式采用 jdkSerializer
        template.setHashValueSerializer(RedisSerializer.java());
        template.setHashValueSerializer(RedisSerializer.java());
        template.afterPropertiesSet();
        return template;
    }
}
