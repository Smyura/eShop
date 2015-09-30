package com.ua.myprojects.eshop.dao;

import java.util.List;

import com.ua.myprojects.eshop.service.model.Category;
import com.ua.myprojects.eshop.service.model.CategoryType;
import com.ua.myprojects.eshop.service.model.CommonResponse;
import com.ua.myprojects.eshop.service.model.Product;

public interface Dao {
	CommonResponse<List<Category>> queryCategories();

	List<Product> queryProductsByCategory(CategoryType categoryName);

	void setConnector(DbConnector connector);
}
