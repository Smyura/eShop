package com.ua.myprojects.eshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DbConnector {
	Connection getConnection(DbConnectionRequest request) throws SQLException;

	void closeConnection(ResultSet result, Statement statement, Connection connection);
}
