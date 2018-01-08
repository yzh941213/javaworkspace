package com.aishidai.app.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Springboot 启动类
 */
@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableCaching //开启缓存
@MapperScan("com.aishidai.app.dao")//扫描 包下相应的class 主要是mybatis 的持久化类
public class App {

	public static void main(String[] args) {
		System.out.printf("================开始启动===========");
		SpringApplication.run(App.class, args);
	}
}
