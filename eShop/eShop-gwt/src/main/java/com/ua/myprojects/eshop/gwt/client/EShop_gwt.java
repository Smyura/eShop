package com.ua.myprojects.eshop.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.ua.myprojects.eshop.gwt.client.callback.QueryCatygoriesCallback;

public class EShop_gwt implements EntryPoint {
	// private Logger logger = Logger.getLogger(EShop_gwt.class.getName());

	private final CategoryServiceAsync categoryService = GWT.create(CategoryService.class);

	@Override
	public void onModuleLoad() {
		createUserPanel();
		createLogoSearchPanel();
		createCategoriesTabPanel();
	}

	private void createUserPanel() {
		VerticalPanel userPanel = new VerticalPanel();
		userPanel.setStylePrimaryName("userPanel");
		Label userLabel = new Label("USER PANEL");
		userPanel.add(userLabel);
		RootPanel.get("USER_PANEL").add(userPanel);
	}

	private void createLogoSearchPanel() {
		HorizontalPanel integratedLogoSearchPanel = new HorizontalPanel();
		integratedLogoSearchPanel.setStylePrimaryName("logoAndSearchPanel");

		HorizontalPanel searchPanel = new HorizontalPanel();
		Label phoneLabel = new Label("(044)515-95-05");
		TextBox searchTxBox = new TextBox();
		Button searchButton = new Button("Search");

		phoneLabel.setStylePrimaryName("phoneLabel");
		searchTxBox.setStylePrimaryName("searchTxBox");
		searchButton.setStylePrimaryName("searchButton");
		searchPanel.add(searchTxBox);
		searchPanel.add(searchButton);
		VerticalPanel phoneSearchPanel = new VerticalPanel();
		phoneSearchPanel.add(phoneLabel);
		phoneSearchPanel.add(searchPanel);

		integratedLogoSearchPanel.add(new Image("images/shop_logo.jpg"));
		integratedLogoSearchPanel.add(phoneSearchPanel);

		RootPanel.get("LOGO_AND_SEARCH_PANEL").add(integratedLogoSearchPanel);
	}

	private void createCategoriesTabPanel() {
		final TabPanel categoriesTabBar = new TabPanel();
		categoriesTabBar.setAnimationEnabled(true);
		categoriesTabBar.getElement().getStyle().setMarginBottom(10.0, Unit.PX);

		categoryService.queryCategoriesTitles(new QueryCatygoriesCallback().addCategotiesTabBar(categoriesTabBar));

		// RootLayoutPanel.get().add(categoriesTabBar);
		RootPanel.get("PRODUCT_CATEGORIES_TAB_PANEL").add(categoriesTabBar);
	}

}
