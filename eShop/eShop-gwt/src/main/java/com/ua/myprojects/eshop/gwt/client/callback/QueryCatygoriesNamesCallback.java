//package com.ua.myprojects.eshop.gwt.client.callback;
//
//import java.util.List;
//import java.util.logging.Logger;
//
//import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.google.gwt.user.client.ui.Anchor;
//import com.google.gwt.user.client.ui.TabPanel;
//
//public class QueryCatygoriesNamesCallback implements AsyncCallback<List<String>> {
//	private Logger logger = Logger.getLogger(QueryCatygoriesNamesCallback.class.getName());
//	private TabPanel categotiesTabBar;
//
//	@Override
//	public void onFailure(Throwable error) {
//		logger.info("FAILED: \n" + error.getMessage());
//	}
//
//	@Override
//	public void onSuccess(List<String> categoriesTitle) {
//		logger.info("QueryCategories response status: SUCCESS");
//		for (String category : categoriesTitle) {
//
//			String productTypeName = "123";
//			Anchor productTypeAnchor = new Anchor(productTypeName);
//			categotriesPanel.add(productTypeAnchor);
//
//			categotiesTabBar.add(categotriesPanel, category);
//
//			logger.info("response: " + category);
//		}
//	}
//
//	public AsyncCallback<List<String>> addCategotiesTabBar(TabPanel categotiesTabBar) {
//		this.categotiesTabBar = categotiesTabBar;
//		return this;
//	}
// }
