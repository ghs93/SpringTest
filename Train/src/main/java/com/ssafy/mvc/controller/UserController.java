package com.ssafy.mvc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/moveLogin")
	public String moveLogin() {
		return "member/login";
	}
	
	@GetMapping("/moveJoin")
	public String moveJoin() {
		return "member/join";
	}
	
	@PostMapping("/doLogin")
	public String login(User user, HttpSession session) throws SQLException {
		
		User login = userService.login(user);
		
		if(login != null) {
			session.setAttribute("userInfo", login);
		}
		
		return "home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	@PostMapping("/doJoin")
	public String join(User user, HttpSession session) throws SQLException {
		User result = userService.join(user);
		
		if(result != null)
			session.setAttribute("userInfo", result);
		
		return "redirect:/";
	}
}
