package com.ua.myprojects.eshop.properties;

public interface JdbcPropertiesReader {
	String getConnectionType();

	String getHost();

	String getPort();

	String getDbName();

	String getDbType();

	String getUserName();

	String getPassword();
}
