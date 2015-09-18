package com.ua.myprojects.eshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ua.myprojects.eshop.properties.JdbcPropertiesReader;
import com.ua.myprojects.eshop.service.model.Category;

@Named
public class JdbcDaoImpl implements Dao {
	private Logger logger = LoggerFactory.getLogger(JdbcDaoImpl.class);

	@Inject
	private JdbcPropertiesReader jdbcPropertiesReader;

	@Inject
	private DbConnector connector;

	// TODO move somewhere selects
	private final static String SELECT_CATEGORIES = "SELECT n.Name, t.Title, t.Priority FROM category_names n "
			+ "inner join  category_titles t on " + "n.CategoryTiltleID = t.ID;";

	private DbConnectionRequest buildDbConnectionRequest() {
		// TODO use here Dozer mapping
		DbConnectionRequest request = new DbConnectionRequest();
		request.setConnectionType(jdbcPropertiesReader.getConnectionType());
		request.setDbName(jdbcPropertiesReader.getDbName());
		request.setDbType(jdbcPropertiesReader.getDbType());
		request.setHost(jdbcPropertiesReader.getHost());
		request.setPassword(jdbcPropertiesReader.getPassword());
		request.setPort(jdbcPropertiesReader.getPort());
		request.setUserName(jdbcPropertiesReader.getUserName());
		return request;
	}

	@Override
	public List<Category> queryCategories() {
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		List<Category> categoryList = null;
		try {
			connection = connector.getConnection(buildDbConnectionRequest());
			if (connection == null) {
				// TODO throw exception here
				return null;
			}
			statement = connection.createStatement();
			result = statement.executeQuery(SELECT_CATEGORIES);
			if (result == null) {
				logger.info("No categories");
				return null;
			}

			Map<String, Category> categories = new HashMap<String, Category>();

			while (result.next()) {
				String title = result.getString("Title");
				Category category = categories.get(title);
				if (category == null) {
					category = new Category();
					categories.put(title, category);
				}
				category.setTitle(title);
				category.setPriority(Integer.valueOf(result.getString("Priority")));
				category.getNames().add(result.getString("Name"));
			}

			categoryList = new ArrayList<Category>();
			categoryList.addAll(categories.values());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connector.closeConnection(result, statement, connection);
		}

		return categoryList;
	}

	@Override
	public void setConnector(DbConnector connector) {
		this.connector = connector;
	}

}
