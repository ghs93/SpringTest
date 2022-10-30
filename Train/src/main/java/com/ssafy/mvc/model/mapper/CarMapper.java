package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.dto.Car;

@Mapper
public interface CarMapper {
	public void registCar(Car car) throws SQLException;
	public List<Car> selectCarList() throws SQLException;
	public Car selectDetail(int number) throws SQLException;
	void insertFileInfo(Car car) throws SQLException;
}
