package com.ssafy.test.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.test.interceptor.SessionConfirmInterceptor;

@Configuration
@EnableAspectJAutoProxy //aop autoProxy 설정
@MapperScan(basePackages = {"com.ssafy.test.model.mapper"}) //mapper 빈 등록
public class WebMvcConfig implements WebMvcConfigurer {
	//인터셉터 등록
	@Autowired
	private SessionConfirmInterceptor sessionConfirmInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionConfirmInterceptor)
			.addPathPatterns("/book")
			.excludePathPatterns("/book/list");
	}
	
	//정적 자원 경로 매핑
	// /assets로 시작하는 요청 시
	// src/main/webapp/resources/assets로 매핑 시켜줌
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**")
			.addResourceLocations("/resources/assets/");
	}
}
