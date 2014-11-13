package com.ua.myprojects.eshop.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CategoryServiceAsync {
	void queryCategories(AsyncCallback<List<String>> list);
}
