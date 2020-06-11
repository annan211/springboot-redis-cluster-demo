package com.test.RedisDemo.redis.config;

import com.test.RedisDemo.redis.proper.RedisObjectSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;
import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    ClusterConfigurationProperties clusterConfigurationProperties;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(
                new RedisClusterConfiguration(clusterConfigurationProperties.getNodes()));
        redisConnectionFactory.setUsePool(Boolean.TRUE);
        redisConnectionFactory.setPoolConfig(jedisPoolConfig());
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<Serializable, Serializable> redisTemplate(RedisConnectionFactory connectionFactory) throws UnknownHostException {
        logger.warn("init RedisTemplate instance");
        RedisTemplate<Serializable, Serializable> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(jackson2JsonRedisSerializer());
        logger.warn("init RedisTemplate is {} ",template);
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory) throws UnknownHostException {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //for each node connection count
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMinIdle(2);
        //because it is single threaded after timeout it will release connection
        jedisPoolConfig.setMaxWaitMillis(2000);
        return jedisPoolConfig;
    }

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public Jackson2JsonRedisSerializer jackson2JsonRedisSerializer() {
        return new Jackson2JsonRedisSerializer(String.class);
    }

}
