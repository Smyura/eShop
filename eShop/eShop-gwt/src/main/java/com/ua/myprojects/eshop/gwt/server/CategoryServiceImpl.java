package com.ua.myprojects.eshop.gwt.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.dozer.Mapper;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ua.myprojects.eshop.gwt.client.CategoryService;
import com.ua.myprojects.eshop.gwt.server.builder.ResponseBuilder;
import com.ua.myprojects.eshop.gwt.shared.model.Category;
import com.ua.myprojects.eshop.gwt.shared.model.CommonResponse;
import com.ua.myprojects.eshop.gwt.shared.model.RequestStatus;
import com.ua.myprojects.eshop.service.CategoryServiceInterface;

public class CategoryServiceImpl extends RemoteServiceServlet implements CategoryService {
	Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());

	private ResponseBuilder<List<Category>> responseBuilder;

	private Mapper beanMapper;

	// TODO thought property
	private String url = "http://localhost:8080/eShop_service";
	private static final long serialVersionUID = 1L;
	private CategoryServiceInterface service;

	@Override
	public CommonResponse<List<Category>> queryCategoriesTitles() {
		// TODO it's too redundant to init service per request
		service = initService(CategoryServiceInterface.class);

		com.ua.myprojects.eshop.service.model.CommonResponse<List<com.ua.myprojects.eshop.service.model.Category>> response = service
				.queryProductCategories();

		if (com.ua.myprojects.eshop.service.model.RequestStatus.ERROR.equals(response.getStatus().getRequestStatus())) {
			String values = null;
			// for (String value :
			// response.getStatus().getMessageDatas().get(0).getMsgValues()) {
			// values += value + ",";
			// }
			// logger.info("ERROR: " +
			// response.getStatus().getMessageDatas().get(0).getMsgText() +
			// " / " + values);

			for (com.ua.myprojects.eshop.service.model.MessageData messageData : response.getStatus().getMessageDatas()) {
				// TODO map messageData
			}
			return responseBuilder
			// ddd
					.addStatus(RequestStatus.ERROR)
					// addMessageDatas(messageDatas).
					.build();
		}

		Collections.sort(response.getContent());

		// List<Category> categoriesGui = new ArrayList<Category>();
		// List<String> categoriesTitlesGui = new ArrayList<String>();
		// for (com.ua.myprojects.eshop.service.model.Category category :
		// response.getContent()) {
		// Category categoryGui = new Category();
		// categoryGui.setTitle(category.getTitle());
		// categoryGui.setNames(category.getNames());
		// categoriesTitlesGui.add(category.getTitle());
		// categoriesGui.add(categoryGui);
		// }

		List<Category> categories = new ArrayList<Category>();
		for (com.ua.myprojects.eshop.service.model.Category category : response.getContent()) {
			categories.add(beanMapper.map(category, Category.class));
		}
		return responseBuilder.addStatus(com.ua.myprojects.eshop.gwt.shared.model.RequestStatus.SUCCESS)
				.addContent(categories).build();
	}

	public void setResponseBuilder(ResponseBuilder<List<Category>> responseBuilder) {
		this.responseBuilder = responseBuilder;
	}

	public void setBeanMapper(Mapper beanMapper) {
		this.beanMapper = beanMapper;
	}

	private <T> T initService(Class<T> clazz) {
		return ProxyFactory.create(clazz, url, new ApacheHttpClient4Executor() {
			@Override
			@SuppressWarnings({ "rawtypes" })
			public ClientResponse execute(ClientRequest request) throws Exception {
				return super.execute(request);
			}
		});
	}

}
