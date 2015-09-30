package com.ua.myprojects.eshop.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import com.ua.myprojects.eshop.service.model.CommonResponse;

public interface DbConnector<T> {
	CommonResponse<T> getConnection();

	void closeConnection(ResultSet result, Statement statement, T connection);
}
