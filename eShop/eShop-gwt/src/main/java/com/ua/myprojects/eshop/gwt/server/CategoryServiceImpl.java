package com.ua.myprojects.eshop.gwt.server;

import java.util.logging.Logger;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ua.myprojects.eshop.gwt.client.CategoryService;

public class CategoryServiceImpl extends RemoteServiceServlet implements CategoryService {
	Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());

	private String url;
	private static final long serialVersionUID = 1L;

	@Override
	public String queryCategories() {
		logger.info("init service");
		// CategoryServiceInterface service =
		// initService(CategoryServiceInterface.class);
		return "Hello";// service.queryCategories().get(0).getName();
	}

	private <T> T initService(Class<T> clazz) {

		return ProxyFactory.create(clazz, url, new ApacheHttpClient4Executor() {

			@Override
			@SuppressWarnings({ "rawtypes" })
			public ClientResponse execute(ClientRequest request) throws Exception {
				// request.header(AUTH_TOKEN, executionContext.getEcmToken());
				return super.execute(request);
			}
		});
	}

}
