package com.ua.myprojects.eshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcConnector implements DbConnector {
	private Logger logger = LoggerFactory.getLogger(JdbcConnector.class);
	private static final String HOST = "HOST";

	@Override
	public Connection getConnection(DbConnectionRequest request) throws SQLException {
		// TODO add request validation
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		String url = request.getConnectionType() + ":" + request.getDbType() + "://" + request.getHost() + ":"
				+ request.getPort() + "/" + request.getDbName() + "?user=" + request.getUserName() + "&password="
				+ request.getPassword();
		logger.info("Try to connect to: '" + url + "'");
		Connection connection = DriverManager.getConnection(url);
		if (connection == null) {
			logger.error("ERROR: can't connect to DB server: '" + request.getHost() + ":" + request.getPort());
			// TODO throw exception here
			return null;
		}
		connection.getClientInfo().setProperty(HOST, request.getHost());

		logger.info("Successfull connected to DB server: '" + connection.getClientInfo(HOST) + ":" + request.getPort()
				+ "'");
		return connection;
	}

	@Override
	public void closeConnection(ResultSet result, Statement statement, Connection connection) {
		try {
			if (result != null) {
				result.close();
				logger.info("Closed ResultSet");
			}
			if (statement != null) {
				statement.close();
				logger.info("Closed Statement");
			}
			if (connection != null) {
				connection.close();
				logger.info("Closed Connenction");
			}
		} catch (SQLException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("Can't close DB server connect");
			}
		}
	}
}
