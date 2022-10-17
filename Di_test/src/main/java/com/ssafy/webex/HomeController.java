package com.ssafy.webex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.webex.model.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//Autowired - 해당 인터페이스를 구현한 Bean 객체를 자동적으로 주입해줌
	@Autowired
	HomeService homeService;
	
	//의존성 주입을 위한 생성자 함수
//	public HomeController(HomeService homeService) {
//		this.homeService = homeService;
//	}
	
	//의존성 주입을 위한 setter 함수
//	public void setHomeService(HomeService homeService) {
//		this.homeService = homeService;
//	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println(homeService);
		
		return "home";
	}
	
}
