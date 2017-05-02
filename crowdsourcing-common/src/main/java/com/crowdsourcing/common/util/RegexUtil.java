package com.crowdsourcing.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
* 正则工具 
* @author  HiYellowC
* @date 创建时间：2017年3月28日 下午7:20:36 
* @version 1.0 * @parameter  
* @since  
* @return
*/

public class RegexUtil {
	
	public static boolean isMatchCustomRegex(String str, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
}
