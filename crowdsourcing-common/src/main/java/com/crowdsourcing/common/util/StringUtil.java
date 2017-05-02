package com.crowdsourcing.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/***
*字符串判断处理工具类 
* @author  HiYellowC
* @date 创建时间：2017年3月16日 下午3:09:32 
* @version 1.0 * @parameter  
* @since  
* @return
*/

public class StringUtil {

	public static boolean isBlankString(String str) {
		return str == null || "".equals(str);
	}
	
	public static boolean isEqualString(String str1, String str2) {
		return str1 != null && str1.equals(str2);
	}
	
	public static boolean isValidDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
}
