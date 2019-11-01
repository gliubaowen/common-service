package com.ibm.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * 
 * @author LiuBaoWen
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.ibm.common" })
public class CommonServiceApplication {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(CommonServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CommonServiceApplication.class, args);
	}

}
