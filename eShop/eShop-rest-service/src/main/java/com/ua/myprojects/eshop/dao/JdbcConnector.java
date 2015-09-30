package com.ua.myprojects.eshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ua.myprojects.eshop.builder.ResponseBuilder;
import com.ua.myprojects.eshop.properties.JdbcPropertiesReader;
import com.ua.myprojects.eshop.service.model.CommonResponse;
import com.ua.myprojects.eshop.service.model.MessageCode;
import com.ua.myprojects.eshop.service.model.RequestStatus;

public class JdbcConnector implements DbConnector<Connection> {
	private Logger logger = LoggerFactory.getLogger(JdbcConnector.class);

	@Inject
	private JdbcPropertiesReader jdbcPropertiesReader;
	@Inject
	private Mapper beanMapper;

	@Inject
	private ResponseBuilder<Connection> responseBuilder;

	private DbConnectionRequest buildDbConnectionRequest() {
		return beanMapper.map(jdbcPropertiesReader, DbConnectionRequest.class);
	}

	@Override
	public CommonResponse<Connection> getConnection() {
		// TODO add request validation
		DbConnectionRequest request = buildDbConnectionRequest();
		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			String url = request.getConnectionType() + ":" + request.getDbType() + "://" + request.getHost() + ":"
					+ request.getPort() + "/" + request.getDbName() + "?user=" + request.getUserName() + "&password="
					+ request.getPassword();
			logger.info("Try to connect to: '" + url + "'");

			connection = DriverManager.getConnection(url);
			if (connection == null) {
				logger.error("ERROR: can't connect to DB server: '" + request.getHost() + ":" + request.getPort());

				return responseBuilder
						.addStatus(RequestStatus.ERROR)
						.addMessageData(MessageCode.ESHOPDB0xx_DB_CONNECTION_ERROR, request.getHost(),
								request.getPort()).build();
			}
		} catch (SQLException e) {
			logger.error("ERROR: exception during connection to DB server: '" + request.getHost() + ":"
					+ request.getPort());
			return responseBuilder.addStatus(RequestStatus.ERROR)
					.addMessageData(MessageCode.ESHOPDB0xx_DB_CONNECTION_ERROR, request.getHost(), request.getPort())
					.build();
		}

		// connection.getClientInfo().setProperty(HOST, request.getHost());
		// logger.info("Successfull connected to DB server: '" +
		// connection.getClientInfo(HOST) + ":" + request.getPort()
		// + "'");
		logger.info("Successfull connected to DB server: '" + request.getHost() + ":" + request.getPort() + "'");
		return responseBuilder.addStatus(RequestStatus.SUCCESS).addContent(connection).build();
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
