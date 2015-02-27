package com.ua.myprojects.eshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ua.myprojects.eshop.service.model.Category;

@Named
public class CategoryService implements CategoryServiceInterface {
	private final Logger logger = LoggerFactory.getLogger(CategoryService.class);

	@Resource(name = "jdbcProperties")
	private Properties jdbc;

	@Override
	public List<Category> queryCategories() {
		// TODO lets use AOP here
		logger.info("--- Starting " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ...");

		logger.info("--- -> " + jdbc.getProperty("host"));

		Category category1 = new Category();
		category1.setTitle("Notebooks, Pads, PCs");
		List<String> names1 = new ArrayList<String>();
		names1.add("Notebooks");
		names1.add("Pads");
		names1.add("PCs");
		category1.setNames(names1);

		Category category2 = new Category();
		category2.setTitle("Phones");
		List<String> names2 = new ArrayList<String>();
		names2.add("Mobile phones");
		names2.add("Radio phones");
		category2.setNames(names2);

		Category category3 = new Category();
		category3.setTitle("Home technics");
		List<String> names3 = new ArrayList<String>();
		names3.add("Air conditioners");
		names3.add("Frizers");
		names3.add("TVs");
		category3.setNames(names3);

		List<Category> categories = new ArrayList<Category>();
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);

		// TODO lets use AOP here
		logger.info("--- Ending " + Thread.currentThread().getStackTrace()[1].getMethodName() + " !");

		return categories;
	}

	// @Override
	// public List<String> queryCategoriesNames(String title) {
	// if (title == null) {
	// return null;
	// }
	//
	// for (Category category : categories) {
	// if (title.equals(category.getTitle())) {
	// return category.getNames();
	// }
	// }
	//
	// return null;
	// }

}
