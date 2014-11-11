package com.ua.myprojects.eshop.gwt.server;

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

	@Override
	public String queryCategories() {
		CategoryServiceInterface service = initService(CategoryServiceInterface.class);
		Category category = new Category();
		category.setName(service.queryCategories().get(0).getName());
		
		//TODO clarify: How does GUI return from server gwt to client gwt? Are they complex types or simple ? 
		return category.getName();
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
