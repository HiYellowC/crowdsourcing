package com.crowdsourcing.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	@Test
	public void testJedisSingle() throws Exception {
		
		// 创建一个Jedis对象
		Jedis jedis = new Jedis("120.25.238.59", 6379);
		jedis.set("test", "hello jedis");
		String str = jedis.get("test");
		System.out.println(str);
		jedis.close();
		
	}
	
	//使用连接池
	@Test
	public void testJedisPool() throws Exception {
		//创建一个连接池对象
		//系统中连接池对象应该是单例的
		JedisPool jedisPool = new JedisPool("192.168.14.129", 6379);
		//从连接池中获得一个连接
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get("test");
		System.out.println(result);
		//jedis必须关闭 否则连接池不能回收
		jedis.close();
		jedisPool.close();
	}
	
	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("cliet1", "1000");
		String str = jedisClient.get("cliet1");
		System.out.println(str);
	}
	
}
