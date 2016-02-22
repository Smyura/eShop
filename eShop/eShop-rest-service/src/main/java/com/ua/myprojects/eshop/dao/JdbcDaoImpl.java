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

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ua.myprojects.eshop.builder.ResponseBuilder;
import com.ua.myprojects.eshop.service.model.Category;
import com.ua.myprojects.eshop.service.model.CategoryType;
import com.ua.myprojects.eshop.service.model.CommonResponse;
import com.ua.myprojects.eshop.service.model.MessageCode;
import com.ua.myprojects.eshop.service.model.Product;
import com.ua.myprojects.eshop.service.model.RequestStatus;

@Named
public class JdbcDaoImpl<T> implements Dao {
	private Logger logger = LoggerFactory.getLogger(JdbcDaoImpl.class);

	@Inject
	private DbConnector<Connection> connector;

	@Inject
	private ResponseBuilder<List<Category>> responseBuilder;

	// TODO move somewhere selects
	private final static String SELECT_CATEGORIES = "SELECT n.Name, t.Title, t.Priority FROM category_names n "
			+ "inner join  category_titles t on " + "n.CategoryTiltleID = t.ID;";

	@Override
	public CommonResponse<List<Category>> queryCategories() {
		CommonResponse<Connection> connectionResponse = null;
		Statement statement = null;
		ResultSet result = null;
		List<Category> categoryList = null;
		try {
			// TODO update to use connections pool
			connectionResponse = connector.getConnection();
			if (connectionResponse == null) {
				logger.info("connectionResponse == null");
			}
			if (RequestStatus.ERROR.equals(connectionResponse.getStatus().getRequestStatus())) {
				return responseBuilder.addStatus(connectionResponse.getStatus().getRequestStatus())
						.addMessageDatas(connectionResponse.getStatus().getMessageDatas()).build();
			}
			statement = connectionResponse.getContent().createStatement();
			result = statement.executeQuery(SELECT_CATEGORIES);
			if (result == null) {
				logger.info("No categories");
				return responseBuilder.addStatus(RequestStatus.ERROR)
						.addMessageData(MessageCode.ESHOPDB0xx_MISSING_DB_DATA, "Categories").build();
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
			logger.info("Successfully got data");
			categoryList = new ArrayList<Category>();
			categoryList.addAll(categories.values());

			if (CollectionUtils.isEmpty(categoryList)) {
				return responseBuilder.addStatus(RequestStatus.ERROR)
						.addMessageData(MessageCode.ESHOPDB0xx_MISSING_DB_DATA, "Categories").build();
			}
		} catch (SQLException e) {
			return responseBuilder.addStatus(RequestStatus.ERROR)
					.addMessageData(MessageCode.ESHOPDB0xx_FETCHING_DB_DATA_ERROR, "Categories").build();
		} finally {
			connector.closeConnection(result, statement, connectionResponse.getContent());
		}

		return responseBuilder.addStatus(RequestStatus.SUCCESS).addContent(categoryList).build();
	}

	@Override
	public List<Product> queryProductsByCategory(CategoryType categoryName) {
		return null;
	}

	@Override
	public void setConnector(DbConnector connector) {
		this.connector = connector;
	}

}
