package com.tanzuhao.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author tanzuhao
 * @date: 2019年9月9日 下午5:22:15
 */
@EnableSwagger2
@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
