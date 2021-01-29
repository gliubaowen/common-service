package com.lbw.common.service;

import javax.xml.ws.Endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lbw.common.service.webservices.impl.WeatherInterfaceImpl;

/**
 * 启动类
 * 
 * @author LiuBaoWen
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.lbw.common" })
public class CommonServiceApplication {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(CommonServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CommonServiceApplication.class, args);
		
		Endpoint.publish("http://127.0.0.1:8081/weather", new WeatherInterfaceImpl());
		
	}

}
