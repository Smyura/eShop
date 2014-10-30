package com.ua.myprojects.eshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ua.myprojects.eshop.service.model.Category;

@Named
public class CategoryService implements CategoryServiceInterface {
	private final Logger logger = LoggerFactory.getLogger(CategoryService.class);

	@Override
	public List<Category> queryCategories() {
		// TODO lets use AOP here
		logger.info("--- Starting " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ...");

		Category category = new Category();
		category.setName("category1");

		List<Category> categories = new ArrayList<Category>();
		categories.add(category);
		logger.info(categories.get(0).getName());

		// TODO lets use AOP here
		logger.info("--- Ending " + Thread.currentThread().getStackTrace()[1].getMethodName() + " !");

		return categories;
	}

}
