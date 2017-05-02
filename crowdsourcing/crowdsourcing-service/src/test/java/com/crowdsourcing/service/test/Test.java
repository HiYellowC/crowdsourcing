package com.crowdsourcing.service.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crowdsourcing.common.util.JsonUtil;
import com.crowdsourcing.jedis.JedisClient;
import com.crowdsourcing.pojo.TbUser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Test {

	private ApplicationContext applicationContext;

	@org.junit.Test
	public void test() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("cliet1", "1000");
		String str = jedisClient.get("cliet1");
		System.out.println(str);
	}
	
	@org.junit.Test
	public void testJsonUtil() {
		TbUser user = new TbUser();
		user.setId((long) 1);
		user.setPassword("123");
		user.setRole("admin");
		String str = new String();
		try {
			str = JsonUtil.objectToJson(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			TbUser userCopy = JsonUtil.jsonToObject(str, TbUser.class);
			System.out.println("user" + userCopy);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("str: " + str);
	}
	
}
