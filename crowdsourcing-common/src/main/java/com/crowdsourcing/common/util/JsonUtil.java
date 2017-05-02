package com.crowdsourcing.common.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/***
* json工具类 
* @author  HiYellowC
* @date 创建时间：2017年3月17日 下午9:39:38 
* @version 1.0 * @parameter  
* @since  
* @return
*/

public class JsonUtil {
	
	private final static ObjectMapper objectMapper = new ObjectMapper();
	
	public static String objectToJson(Object object) throws JsonProcessingException {
		return objectMapper.writeValueAsString(object);
	}
	
	public static <T> T jsonToObject(String string, Class<T> cla) throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(string, cla);
	}
	
}
