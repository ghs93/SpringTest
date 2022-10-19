package com.ssafy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.dto.Car;
import com.ssafy.mvc.model.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarService carService;
	
	@RequestMapping("/regist")
	public String showRegistCar() {
		return "carRegist";
	}
	
	@GetMapping("/doRegist")
	public String registCar(@RequestParam String num
			, @RequestParam String brand
			, @RequestParam String model
			, @RequestParam int price) throws SQLException {
		Car car = new Car();
		car.setNumber(num);
		car.setBrand(brand);
		car.setModel(model);
		car.setPrice(price);
		
		carService.registCar(car);
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String getCarList(Model model) throws SQLException {
		List<Car> list = carService.getCarList();
		model.addAttribute("carList", list);
		
		return "carList";
	}
}
