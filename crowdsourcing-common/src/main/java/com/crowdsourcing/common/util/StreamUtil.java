package com.crowdsourcing.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/***
* IO工具类 
* @author  HiYellowC
* @date 创建时间：2017年3月16日 下午3:12:56 
* @version 1.0 * @parameter  
* @since  
* @return
*/

public class StreamUtil {

	public static void putBytesIntoOutputStream(OutputStream outputStream, byte[] bytes) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(bytes);  
        int len = 0;  
        byte[] buf = new byte[1024];  
        while ((len = inputStream.read(buf,0,1024))!= -1) { 
            outputStream.write(buf, 0, len);  
        }
        if (inputStream != null) {
        	inputStream.close();
        }
	}
	
	public static byte[] getBytesFromInputStream(InputStream inputStream) throws IOException {
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		
		int len = 0;
		while ((len = inputStream.read(buff, 0, 1024)) != -1) {
			outputStream.write(buff, 0, len);
		}
		
		byte[] bytes = outputStream.toByteArray();
		if (outputStream != null) {
			outputStream.close();
		}
		
		return bytes;
	}
	
}
