package com.ssafy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.model.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/book")
@Slf4j
public class BookController {
	
	//BookService 객체 주입
	@Autowired
	BookService bookService;

//	@RequestMapping(value = "/list")
//	public ModelAndView showBookList(ModelAndView mv) throws SQLException {
//		System.out.println("showBookList() 메소드 호출");
//		
//		//1. 전체 목록 조회 데이터 받아오기
//		List<Book> list = bookService.selectAll();
//		
//		System.out.println(list);
//		
//		//Model로 처리한 결과를 담기
//		mv.addObject("list", list);
//		
//		//View 정보 담기
//		mv.setViewName("bookList");
//		
//		//2. view 반환
//		return mv;
//	}
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list")
	public String showBookList(Model model
//			, @RequestParam("a") int a
//			, @RequestParam("b") int b
			) throws SQLException {
		log.debug("showBookList() 메소드 호출");
		
		//1. 전체 목록 조회 데이터 받아오기
		List<Book> list = bookService.selectAll();
		
		System.out.println(list);
//		System.out.println("a: " + a);
//		System.out.println("b: " + b);
//		System.out.println("c: " + model.getAttribute("c"));
		model.addAttribute("list", list);
		
		log.debug(bookService.getClass().getName());
		
		//2. view 반환
		return "bookList";
	}
	
	@RequestMapping(value = "/list2")
	public String showBookList2(RedirectAttributes re) throws SQLException {
		log.debug("showBookList()2 메소드 호출");
		
		//1. 전체 목록 조회 데이터 받아오기
		List<Book> list = bookService.selectAll();
		
		System.out.println(list);
		
		//리다이렉트 시 정보 넘길 때
		re.addAttribute("a", 10);
		re.addAttribute("b", 20);
		
		//정보를 넘기지만 클라이언트에겐 보이지 않음
		//최초에 한 번 사용하고 새로고침 시엔 사라짐
		re.addFlashAttribute("c", 30);
		
		//2. view 반환 - redirect
		return "redirect:list";
	}
	
}
