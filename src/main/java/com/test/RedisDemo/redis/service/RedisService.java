package com.test.RedisDemo.redis.service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class RedisService  {

	static Logger logger = LoggerFactory.getLogger(RedisService.class);

	private RedisTemplate<Serializable, Serializable> redisTemplate;

	public RedisService(RedisTemplate<Serializable, Serializable> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public Object getObject(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String key,  Class<? extends Serializable> requiredType) {
		Serializable val = redisTemplate.opsForValue().get(key);
		if(val == null){
			return null;
		}
		return ((T)val);
	}

	public boolean remove(String key) {
		return redisTemplate.delete(key);
	}

	public void saveObject(String key, Serializable object) {
		redisTemplate.opsForValue().set(key,object);
		logger.info("save the cache success {} ",key );
	}

	public void saveWithExpireTime(String key, Serializable object, long timeout, TimeUnit unit) {
		redisTemplate.opsForValue().set(key, object, timeout, unit);
	}

	public boolean hasKey(String key) {
		return redisTemplate.hasKey(key);
	}

}