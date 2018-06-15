package com.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
	private static ApplicationContext context=null;
	
	static{
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	public static Object getBean(String beanid){
		return context.getBean(beanid);
	}
	
}
