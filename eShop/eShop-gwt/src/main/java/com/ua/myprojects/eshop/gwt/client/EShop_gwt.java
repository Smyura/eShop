package com.ua.myprojects.eshop.gwt.client;

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EShop_gwt implements EntryPoint {
	Logger logger = Logger.getLogger(EShop_gwt.class.getName());

	private final CategoryServiceAsync categoryService = GWT.create(CategoryService.class);

	@Override
	public void onModuleLoad() {
		logger.info("--- Running GWT App");

		createUserPanel();
		createPhoneSearchPanel();
		createCategoriesTabPanel();
		logger.info("--- Exit GWT App");
	}

	private void createUserPanel() {
		VerticalPanel userPanel = new VerticalPanel();
		userPanel.setStylePrimaryName("userPanel");
		Label userLabel = new Label("USER PANEL");
		userPanel.add(userLabel);
		RootPanel.get("USER_PANEL").add(userPanel);
	}

	private void createPhoneSearchPanel() {
		VerticalPanel integratePhoneSearchPanel = new VerticalPanel();
		integratePhoneSearchPanel.setStylePrimaryName("logoAndSearchPanel");
		RootPanel.get("LOGO_AND_SEARCH_PANEL").add(integratePhoneSearchPanel);
	}

	private void createCategoriesTabPanel() {
		final TabPanel categotiesTabBar = new TabPanel();

		categoryService.queryCategories(new AsyncCallback<List<String>>() {

			@Override
			public void onFailure(Throwable error) {
				logger.info("FAILED: \n" + error.getMessage());
			}

			@Override
			public void onSuccess(List<String> categories) {
				logger.info("SUCCESS");
				for (String category : categories) {
					HorizontalPanel categotriesPanel = new HorizontalPanel();

					String productTypeName = "123";
					Anchor productTypeAnchor = new Anchor(productTypeName);
					categotriesPanel.add(productTypeAnchor);

					categotiesTabBar.add(categotriesPanel, category);

					logger.info("response: " + category);
				}
			}
		});

		RootPanel.get("PRODUCT_CATEGORIES_TAB_PANEL").add(categotiesTabBar);
	}

}
