package com.ua.myprojects.eshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ua.myprojects.eshop.dao.Dao;
import com.ua.myprojects.eshop.service.model.Category;

@Named
public class CategoryService implements CategoryServiceInterface {
	private final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	@Inject
	private Dao dao;

	@Override
	public List<Category> queryCategories() {
		// TODO lets use AOP here
		logger.info("--- Starting " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ...");

		List<Category> categories = dao.queryCategories();
		if (CollectionUtils.isEmpty(categories)) {
			logger.info("--- No Categories in the DB");
			return new ArrayList<Category>();
		}

		// TODO lets use AOP here
		logger.info("--- Ending " + Thread.currentThread().getStackTrace()[1].getMethodName() + " !");

		return categories;
	}

}
