package com.ua.myprojects.eshop.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.ua.myprojects.eshop.gwt.shared.model.Category;
import com.ua.myprojects.eshop.gwt.shared.model.CommonResponse;

@RemoteServiceRelativePath("categories")
public interface CategoryService extends RemoteService {
	CommonResponse<List<Category>> queryCategoriesTitles();
}
