package com.ua.myprojects.eshop.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.ua.myprojects.eshop.gwt.shared.model.Category;
import com.ua.myprojects.eshop.gwt.shared.model.CommonResponse;

public interface CategoryServiceAsync {
	void queryCategoriesTitles(AsyncCallback<CommonResponse<List<Category>>> titles);
}
