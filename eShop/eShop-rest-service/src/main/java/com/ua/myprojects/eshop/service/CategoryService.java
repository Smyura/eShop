package com.ua.myprojects.eshop.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ua.myprojects.eshop.builder.ResponseBuilder;
import com.ua.myprojects.eshop.dao.Dao;
import com.ua.myprojects.eshop.service.model.Category;
import com.ua.myprojects.eshop.service.model.CommonResponse;
import com.ua.myprojects.eshop.service.model.RequestStatus;

@Named
public class CategoryService implements CategoryServiceInterface {
	private final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	@Inject
	private Dao dao;

	@Inject
	private ResponseBuilder<List<Category>> responseBuilder;

	@Override
	public CommonResponse<List<Category>> queryProductCategories() {
		// TODO lets use AOP here
		logger.info("--- Starting " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ...");

		CommonResponse<List<Category>> responseCategories = dao.queryCategories();
		if (RequestStatus.ERROR.equals(responseCategories.getStatus().getRequestStatus())) {
			return responseBuilder.addStatus(RequestStatus.ERROR)
					.addMessageDatas(responseCategories.getStatus().getMessageDatas()).build();
		}

		// TODO lets use AOP here
		logger.info("--- Ending " + Thread.currentThread().getStackTrace()[1].getMethodName() + " !");
		return responseBuilder.addStatus(RequestStatus.SUCCESS).addContent(responseCategories.getContent()).build();
	}
}
