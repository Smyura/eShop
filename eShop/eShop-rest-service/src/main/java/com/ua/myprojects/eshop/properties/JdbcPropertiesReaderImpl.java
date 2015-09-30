package com.ua.myprojects.eshop.properties;

import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Configuration
//@PropertySource(value = "classpath:jdbc.properties")
public class JdbcPropertiesReaderImpl implements JdbcPropertiesReader {
	private final Logger logger = LoggerFactory.getLogger(JdbcPropertiesReaderImpl.class);

	@Resource(name = "jdbcProperties")
	private Properties jdbc;

	// @Value("${host}")
	// private String host;
	//
	// @Override
	// public String getHost() {
	// logger.info("--- -> " + host);
	// return host;
	// }

	@Override
	public String getHost() {
		return jdbc.getProperty(EshopPropertiesFields.HOST.name());
	}

	@Override
	public String getConnectionType() {
		return jdbc.getProperty(EshopPropertiesFields.CONNECTION_TYPE.name());
	}

	@Override
	public String getPort() {
		return jdbc.getProperty(EshopPropertiesFields.PORT.name());
	}

	@Override
	public String getDbName() {
		return jdbc.getProperty(EshopPropertiesFields.DATA_BASE_NAME.name());
	}

	@Override
	public String getDbType() {
		return jdbc.getProperty(EshopPropertiesFields.DATA_BASE_TYPE.name());
	}

	@Override
	public String getUserName() {
		return jdbc.getProperty(EshopPropertiesFields.USER_NAME.name());
	}

	@Override
	public String getPassword() {
		return jdbc.getProperty(EshopPropertiesFields.PASSWORD.name());
	}

}
