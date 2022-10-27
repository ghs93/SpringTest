package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.dto.Car;
import com.ssafy.mvc.model.mapper.CarMapper;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	CarMapper carMapper;

	@Override
	public void registCar(Car car) throws SQLException {
		carMapper.registCar(car);
		
		if(car.getFileInfo() != null)
			carMapper.insertFileInfo(car);
		
	}

	@Override
	public List<Car> getCarList() throws SQLException {
		return carMapper.selectCarList();
	}

	@Override
	public Car getDetailCar(int number) throws SQLException {
		return carMapper.selectDetail(number);
	}

}
