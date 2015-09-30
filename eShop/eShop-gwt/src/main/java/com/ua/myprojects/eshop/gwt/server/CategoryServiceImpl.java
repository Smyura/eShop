package com.ua.myprojects.eshop.gwt.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ua.myprojects.eshop.gwt.client.CategoryService;
import com.ua.myprojects.eshop.gwt.shared.model.Category;
import com.ua.myprojects.eshop.service.CategoryServiceInterface;
import com.ua.myprojects.eshop.service.model.CommonResponse;
import com.ua.myprojects.eshop.service.model.RequestStatus;

public class CategoryServiceImpl extends RemoteServiceServlet implements CategoryService {
	Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());

	// TODO thought property
	private String url = "http://localhost:8080/eShop_service";
	private static final long serialVersionUID = 1L;
	private CategoryServiceInterface service;

	@Override
	public List<Category> queryCategoriesTitles() {
		// TODO it's too redundant to init service per request
		service = initService(CategoryServiceInterface.class);

		CommonResponse<List<com.ua.myprojects.eshop.service.model.Category>> categoriesResponse = service
				.queryProductCategories();

		if (RequestStatus.ERROR.equals(categoriesResponse.getStatus().getRequestStatus())) {
			String values = null;
			for (String value : categoriesResponse.getStatus().getMessageDatas().get(0).getMsgValues()) {
				values += value + ",";
			}
			logger.info("ERROR: " + categoriesResponse.getStatus().getMessageDatas().get(0).getMsgText() + " / "
					+ values);
			return null;
		}
		Collections.sort(categoriesResponse.getContent());

		List<Category> categoriesGui = new ArrayList<Category>();
		List<String> categoriesTitlesGui = new ArrayList<String>();
		for (com.ua.myprojects.eshop.service.model.Category category : categoriesResponse.getContent()) {
			Category categoryGui = new Category();
			categoryGui.setTitle(category.getTitle());
			categoryGui.setNames(category.getNames());
			categoriesTitlesGui.add(category.getTitle());
			categoriesGui.add(categoryGui);
		}

		return categoriesGui;
	}

	private void sortCategories(List<com.ua.myprojects.eshop.service.model.Category> categories) {

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
