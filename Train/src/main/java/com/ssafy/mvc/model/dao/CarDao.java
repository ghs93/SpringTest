package com.ssafy.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Car;

public interface CarDao {
	public void registCar(Car car) throws SQLException;
	public List<Car> getCarList() throws SQLException;
}
