package com.ssafy.hello.h4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/h4/application.xml");
		HelloMessage hello = context.getBean("eng", HelloMessageEng.class);
		String greet = hello.hello("안효인");
		System.out.println(greet);
	}

}
