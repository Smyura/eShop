package com.ua.myprojects.eshop.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CategoryServiceAsync {
	void queryCategories(AsyncCallback<String> list);
}
