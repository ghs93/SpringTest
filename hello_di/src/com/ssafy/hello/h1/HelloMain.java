package com.ssafy.hello.h1;

public class HelloMain {

	public static void main(String[] args) {
//		HelloMessageKor kor = new HelloMessageKor();
//		String greet = kor.helloKor("안효인");
		HelloMessageEng kor = new HelloMessageEng();
		String greet = kor.helloEng("안효인");
		System.out.println(greet);
	}

}
