package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;

import com.ssafy.mvc.dto.User;

public interface UserMapper {
	User loginUser(User user) throws SQLException;
}
