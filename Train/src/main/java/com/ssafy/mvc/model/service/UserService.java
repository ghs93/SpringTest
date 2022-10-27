package com.ssafy.mvc.model.service;

import java.sql.SQLException;

import com.ssafy.mvc.dto.User;

public interface UserService {
	User login(User user) throws SQLException;
	User join(User user) throws SQLException;
}
