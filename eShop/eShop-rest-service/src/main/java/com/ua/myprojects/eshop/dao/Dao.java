package com.ua.myprojects.eshop.dao;

import java.util.List;

import com.ua.myprojects.eshop.service.model.Category;

public interface Dao {
	List<Category> queryCategories();

	void setConnector(DbConnector connector);
}
