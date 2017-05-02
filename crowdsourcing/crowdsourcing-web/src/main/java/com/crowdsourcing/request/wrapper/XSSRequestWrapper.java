package com.crowdsourcing.request.wrapper;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;
import org.owasp.validator.html.ScanException;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

	private static Policy policy = null;
	
	static {
		String path = XSSRequestWrapper.class.getClassLoader().getResource("antisamy-slashdot.xml").getFile();
		if (path.startsWith("file")) {
			path = path.substring(6);
		}
		try {
			policy = Policy.getInstance(path);
		} catch (PolicyException e) {
			e.printStackTrace();
		}
	}
	
	public XSSRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@SuppressWarnings("rawtypes")
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> requestMap = super.getParameterMap();
		Iterator iterator = requestMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry)iterator.next();
			String[] values = (String[])me.getValue();
			for (int i = 0; i < values.length; i++) {
				values[i] = XSSClean(values[i]);
			}
		}
		return requestMap;
	}
	
	public String[] getParameterValues(String paramString) {
		String[] arrayOfString1 = super.getParameterValues(paramString);
		if (arrayOfString1 == null) {
			return null;
		}
		int i = arrayOfString1.length;
		String[] arrayOfString2 = new String[i];
		for (int j = 0; j < i; j++) {
			arrayOfString2[j] = XSSClean(arrayOfString1[j]);
		}
		return arrayOfString2;
	}
	
	public String getParameter(String paramString) {
		String str = super.getParameter(paramString);
		if (str == null) {
			return null;
		}
		return XSSClean(str);
	}
	
	public String getHeader(String paramString) {
		String str = super.getHeader(paramString);
		if (str == null) {
			return null;
		}
		return XSSClean(str);
	}
	
	private String XSSClean(String value) {
		AntiSamy antiSamy = new AntiSamy();
		try {
			final CleanResults cr = antiSamy.scan(value, policy);
			System.out.println("clean: " + cr.getCleanHTML());
			return cr.getCleanHTML();
		} catch (ScanException e) {
			e.printStackTrace();
		} catch (PolicyException e) {
			e.printStackTrace();
		}
		return value;
	}
	
}
