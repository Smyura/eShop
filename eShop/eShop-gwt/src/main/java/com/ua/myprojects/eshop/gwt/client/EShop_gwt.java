package com.ua.myprojects.eshop.gwt.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.ua.myprojects.eshop.service.model.Category;

public class EShop_gwt implements EntryPoint {
	private final CategoryServiceAsyncInterface service = GWT.create(CategoryServiceAsyncInterface.class);

	@Override
	public void onModuleLoad() {
		System.out.println("--- Running GWT App");

		service.queryCategories(new AsyncCallback<List<Category>>() {

			@Override
			public void onFailure(Throwable error) {
				System.out.println("FAILED");

			}

			@Override
			public void onSuccess(List<Category> response) {
				System.out.println("SUCCESS");
				for (Category category : response) {
					System.out.println("/t" + category.getName());
				}

			}
		});

		System.out.println("--- Exit GWT App");
	}

}
