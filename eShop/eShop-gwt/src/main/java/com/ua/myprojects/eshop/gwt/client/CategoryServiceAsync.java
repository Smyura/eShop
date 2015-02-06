package com.ua.myprojects.eshop.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.ua.myprojects.eshop.gwt.shared.model.Category;

public interface CategoryServiceAsync {
	void queryCategoriesTitles(AsyncCallback<List<Category>> titles);
}
