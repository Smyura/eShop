package com.ua.myprojects.eshop.gwt.server;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ua.myprojects.eshop.gwt.client.CategoryService;
import com.ua.myprojects.eshop.gwt.model.Category;
import com.ua.myprojects.eshop.service.CategoryServiceInterface;

public class CategoryServiceImpl extends RemoteServiceServlet implements CategoryService {
	Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());

	// TODO thought property
	private String url = "http://localhost:8080/eShop_service";
	private static final long serialVersionUID = 1L;
	private CategoryServiceInterface service;

	@Override
	public List<String> queryCategoriesTitles() {
		service = initService(CategoryServiceInterface.class);

		List<com.ua.myprojects.eshop.service.model.Category> categoriesService = service.queryCategoriesTitles();
		logger.info("categoriesService size: " + categoriesService.size());

		List<Category> categoriesGui = new ArrayList<Category>();
		List<String> categoriesTitlesGui = new ArrayList<String>();
		for (com.ua.myprojects.eshop.service.model.Category category : categoriesService) {
			Category categoryGui = new Category();
			categoryGui.setTitle(category.getTitle());
			categoryGui.setNames(category.getNames());
			categoriesTitlesGui.add(category.getTitle());
			categoriesGui.add(categoryGui);
		}

		// TODO clarify: How does GUI return from server gwt to client gwt? Are
		// they complex types or simple ?
		return categoriesTitlesGui;
	}

	@Override
	public List<String> queryCategoriesNames(String title) {
		if (service == null) {
			return null;
		}

		return service.queryCategoriesNames(title);
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
