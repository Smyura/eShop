package com.ua.myprojects.eshop.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.ua.myprojects.eshop.gwt.shared.model.Category;

@RemoteServiceRelativePath("categories")
public interface CategoryService extends RemoteService {
	List<Category> queryCategoriesTitles();

	List<String> queryCategoriesNames(String title);
}
