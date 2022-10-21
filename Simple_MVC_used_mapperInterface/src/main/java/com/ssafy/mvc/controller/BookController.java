package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.dto.FileInfo;
import com.ssafy.mvc.model.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/book")
@Slf4j
public class BookController {
	
	@Autowired
	//Application Context
	ServletContext servletContext;
	
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
	
	//책 등록 페이지 이동
	@GetMapping("/insert")
	public String goInsertBook() {
		return "insertBook";
	}
	
	//책 등록 요청
	@PostMapping("/insert")
	public String insertBook(Book book, @RequestParam() MultipartFile file) throws SQLException, IllegalStateException, IOException {
		log.debug("책 등록 요청 수신 - 책 정보 {}", book.toString());
		
		log.debug("파일 존재 여부: {}", file.isEmpty());
		
		//파일 정보가 있는 경우
		if(!file.isEmpty()) {
			//1. 파일 업로드
			//파일 업로드할 경로
			String path = servletContext.getRealPath("/upload");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			File folder = new File(path + File.separator + today);
			
			//해당 폴더가 없다면 만들기
			if(!folder.exists()) folder.mkdirs();
			
			String originFile = file.getOriginalFilename(); //원본 파일 명
			//저장될 파일명 만들기
			String saveFile = UUID.randomUUID().toString() + originFile.substring(originFile.lastIndexOf('.'));
			//파일 저장
			file.transferTo(new File(folder, saveFile));
			
			//2. 파일 데이터 DB에 저장
			FileInfo fileInfo = new FileInfo();
			fileInfo.setIsbn(book.getIsbn());
			fileInfo.setSaveFile(saveFile);
			fileInfo.setOriginFile(originFile);
			fileInfo.setSaveFolder(today);
			//책 정보에 파일 데이터 추가
			book.setFileInfo(fileInfo);
		}
		
		//책 정보 DB에 저장
        bookService.insertBook(book);
		
		//책 목록 화면으로 이동
		return "redirect:list";
	}
}
