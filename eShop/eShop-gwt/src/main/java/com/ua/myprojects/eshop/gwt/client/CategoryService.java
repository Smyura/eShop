package com.ua.myprojects.eshop.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("categories")
public interface CategoryService extends RemoteService {
	String queryCategories();
}
