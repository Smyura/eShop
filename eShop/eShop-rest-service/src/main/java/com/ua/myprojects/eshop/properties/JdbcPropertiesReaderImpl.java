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
		if (jdbc == null) {
			logger.info("ERROR: can't read " + EshopProperties.JDBC.getPropertyName() + "property");
			return null;
		}
		return jdbc.getProperty("host");
	}
}
