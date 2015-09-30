package com.ua.myprojects.eshop.gwt.client.callback;

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.ua.myprojects.eshop.gwt.shared.model.Category;

public class QueryCatygoriesCallback implements AsyncCallback<List<Category>> {
	private Logger logger = Logger.getLogger(QueryCatygoriesCallback.class.getName());
	private TabPanel categotiesTabBar;

	@Override
	public void onFailure(Throwable error) {
		logger.info("FAILED: \n" + error.getMessage());
	}

	@Override
	public void onSuccess(List<Category> categoriesTitle) {
		logger.info("QueryCategories response status: SUCCESS");
		for (Category category : categoriesTitle) {
			HorizontalPanel categotriesPanel = new HorizontalPanel();

			for (String productTypeName : category.getNames()) {
				Anchor productTypeAnchor = new Anchor(productTypeName);
				categotriesPanel.add(productTypeAnchor);
			}
			categotiesTabBar.add(categotriesPanel, category.getTitle());
		}
	}

	public AsyncCallback<List<Category>> addCategotiesTabBar(TabPanel categotiesTabBar) {
		this.categotiesTabBar = categotiesTabBar;
		return this;
	}
}
