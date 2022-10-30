package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Car;

public interface CarService {
	public void registCar(Car car) throws SQLException;
	public List<Car> getCarList() throws SQLException;
	public Car getDetailCar(int number) throws SQLException;
}
