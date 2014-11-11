package com.ua.myprojects.eshop.gwt.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class EShop_gwt implements EntryPoint {
	Logger logger = Logger.getLogger(EShop_gwt.class.getName());

	private final CategoryServiceAsync service = GWT.create(CategoryService.class);

	@Override
	public void onModuleLoad() {
		logger.info("--- Running GWT App");
		// System.out.println("--- Running GWT App");

		service.queryCategories(new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable error) {
				logger.info("FAILED: \n" + error.getMessage());
			}

			@Override
			public void onSuccess(String response) {
				logger.info("SUCCESS");
				logger.info("/t" + response);
			}
		});

		logger.info("--- Exit GWT App");
	}

}
