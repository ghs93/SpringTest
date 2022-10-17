package com.ssafy.hello.h3;

public class HelloMain {

	public static void main(String[] args) {
//		HelloMessage hello = new HelloMessageEng();
//		String greet = hello.hello("안효인");
		HelloMessage hello = HelloMessageFactory.getHelloMessage("kor");
		String greet = hello.hello("안효인");
		System.out.println(greet);
	}

}
