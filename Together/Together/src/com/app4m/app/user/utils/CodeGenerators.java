package com.app4m.app.user.utils;

import java.util.Date;

public class CodeGenerators {
	@SuppressWarnings("deprecation")
	public synchronized static String generateCodes(){
		Date date = new Date();
		String code = String.valueOf(date.getTimezoneOffset()) + String.valueOf(date.getSeconds());		
		return code;
	}
}
