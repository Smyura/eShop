package com.ua.myprojects.eshop.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CategoryServiceAsync {
	void queryCategoriesTitles(AsyncCallback<List<String>> titles);

	void queryCategoriesNames(String title, AsyncCallback<List<String>> names);
}
