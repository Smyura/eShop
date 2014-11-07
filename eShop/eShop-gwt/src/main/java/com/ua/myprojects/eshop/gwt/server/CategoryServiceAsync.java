package com.ua.myprojects.eshop.gwt.server;

import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ua.myprojects.eshop.gwt.client.CategoryServiceAsyncInterface;
import com.ua.myprojects.eshop.service.CategoryServiceInterface;
import com.ua.myprojects.eshop.service.model.Category;

public class CategoryServiceAsync extends RemoteServiceServlet implements CategoryServiceAsyncInterface {

	private String url;
	private static final long serialVersionUID = 1L;

	@Override
	public List<Category> queryCategories(AsyncCallback<List<Category>> list) {
		CategoryServiceInterface service = initService(CategoryServiceInterface.class);
		return service.queryCategories();
	}

	protected <T> T initService(Class<T> clazz) {

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
