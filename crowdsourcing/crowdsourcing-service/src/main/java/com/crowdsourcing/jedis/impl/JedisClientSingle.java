package com.crowdsourcing.jedis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crowdsourcing.jedis.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/***
* redis客户端单机版实现 
* @author  HiYellowC
* @date 创建时间：2017年3月17日 下午7:49:12 
* @version 1.0 * @parameter  
* @since  
* @return
*/

public class JedisClientSingle implements JedisClient {

	@Autowired
	private JedisPool jedisPool;

	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}

	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		System.out.println("key: " + key);
		String result = jedis.get(key);
		System.out.println("result: " + result);
		jedis.close();
		return result;
	}

	@Override
	public Long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}
	
	@Override
	public Long hset(String key, String item, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(key, item, value);
		jedis.close();
		return result;
	}

	@Override
	public String hget(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.hget(key, item);
		jedis.close();
		return result;
	}

	@Override
	public Long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	@Override
	public Long decr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.decr(key);
		jedis.close();
		return result;
	}

	@Override
	public Long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}

	@Override
	public Long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	@Override
	public Long hdel(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(key, item);
		jedis.close();
		return result;
	}

	@Override
	public Long lpush(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.lpush(key, value);
		jedis.close();
		return result;
	}

	@Override
	public List<String> lrange(String key, int start, int end) {
		Jedis jedis = jedisPool.getResource();
		List<String> result = jedis.lrange(key, start, end);
		jedis.close();
		return result;
	}

	@Override
	public Long llen(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.llen(key);
		jedis.close();
		return result;
	}
	
	@Override
	public boolean exists(String key) {
		Jedis jedis = jedisPool.getResource();
		boolean result = jedis.exists(key);
		jedis.close();
		return result;
	}

}
