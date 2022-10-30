package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.dto.User;

@Mapper
public interface UserMapper {
	User login(User user) throws SQLException;
	int join(User user) throws SQLException;
}
