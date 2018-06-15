package com.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json  {
	/**
	 * 格式化日期为yyyy-MM-dd HH:mm:ss
	 * */
	public static Gson getJson(){
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
	}
	
	/**
	 * 格式化日期为yyyy-MM-dd
	 * */
	public static Gson getGson(){
		return new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();
	}
	public static Gson getGson(String format){
		return new GsonBuilder().setDateFormat(format).serializeNulls().create();
	}
}
