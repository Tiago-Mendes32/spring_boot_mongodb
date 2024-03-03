package com.legacy.spring_mongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static LocalDate convertDate(String textDate, LocalDate defaultValue) {
	    try {
	        return LocalDate.parse(textDate, fmt);
	    } catch (DateTimeParseException e) {
	        return defaultValue;
	    }
	}
}
