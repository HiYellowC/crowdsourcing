package com.crowdsourcing.other;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class OtherTest {

	@Test
	public void test() {
		Pattern pattern = Pattern.compile("[1-3]");
		Matcher matcher = pattern.matcher(null);
		System.out.println(matcher.matches());
	}

}
