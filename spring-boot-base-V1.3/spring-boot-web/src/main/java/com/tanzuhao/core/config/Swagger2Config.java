package com.tanzuhao.core.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @功能说明: swagger2的配置文件 ,访问UI:http://localhost:8086/swagger-ui.html
 * @author: tanzuhao
 * @创建时间: 2020年11月18日下午1:14:14
 * @公司名称:
 * @版本: V1.0
 */
@Configuration
@EnableSwagger2
// 是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露！），可根据springboot的多环境配置进行设置
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class Swagger2Config {
	/**
	 * 
	 * @describe：swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// 为当前包路径
				.apis(RequestHandlerSelectors.basePackage("com.tanzuhao.core")).paths(PathSelectors.any()).build();
	}

	/**
	 * 
	 * @describe：构建 api文档的详细信息函数,注意这里的注解引用的是哪个
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SpringBoot利用Swagger构建API文档") // 页面标题
				.description("使用RestFul风格, 创建人：tanzuhao")// 描述
				.termsOfServiceUrl("https://github.com/cicadasmile").version("version 1.0")// 版本号
				.build();
	}

}
