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
import com.ua.myprojects.eshop.service.CategoryServiceInterface;
import com.ua.myprojects.eshop.service.model.Category;

public class CategoryServiceImpl extends RemoteServiceServlet implements CategoryService {
	Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());

	// TODO thought property
	private String url = "http://localhost:8080/eShop_service";
	private static final long serialVersionUID = 1L;

	@Override
	public List<String> queryCategories() {
		CategoryServiceInterface service = initService(CategoryServiceInterface.class);
		List<Category> categoriesService = service.queryCategories();
		logger.info("categoriesService size: " + categoriesService.size());
		List<String> categoriesGui = new ArrayList<String>();
		for (Category category : categoriesService) {
			categoriesGui.add(category.getName());
		}

		// TODO clarify: How does GUI return from server gwt to client gwt? Are
		// they complex types or simple ?
		return categoriesGui;
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
