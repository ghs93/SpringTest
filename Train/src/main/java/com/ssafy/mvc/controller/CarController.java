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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.dto.Car;
import com.ssafy.mvc.dto.FileInfo;
import com.ssafy.mvc.model.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	@Autowired
	//Application Context
	ServletContext servletContext;
	
	@Autowired
	CarService carService;
	
	@RequestMapping("/regist")
	public String showRegistCar() {
		return "car/carRegist";
	}
	
	@PostMapping("/doRegist")
	@Transactional
	public String registCar(Car car, @RequestParam MultipartFile file) throws SQLException, IllegalStateException, IOException {
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
			fileInfo.setNumber(car.getNumber());
			fileInfo.setSaveFile(saveFile);
			fileInfo.setOriginFile(originFile);
			fileInfo.setSaveFolder(today);
			
			//차 정보에 파일 데이터 추가
			car.setFileInfo(fileInfo);
		}
		
		carService.registCar(car);
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String getCarList(Model model) throws SQLException {
		List<Car> list = carService.getCarList();
		model.addAttribute("carList", list);
		
		return "car/carList";
	}
	
	@GetMapping("/detail")
	public String detailList(Model model, @RequestParam int number) throws SQLException {
		Car car = carService.getDetailCar(number);
		model.addAttribute("detail", car);
		
		return "car/carDetail";
	}
}
