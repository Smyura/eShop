package com.ua.myprojects.eshop.gwt.client.callback;

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.ua.myprojects.eshop.gwt.client.util.UtilMessage;
import com.ua.myprojects.eshop.gwt.shared.model.Category;
import com.ua.myprojects.eshop.gwt.shared.model.CommonResponse;
import com.ua.myprojects.eshop.gwt.shared.model.RequestStatus;

public class QueryCatygoriesCallback implements AsyncCallback<CommonResponse<List<Category>>> {
	private Logger logger = Logger.getLogger(QueryCatygoriesCallback.class.getName());
	private TabPanel categotiesTabBar;

	@Override
	public void onFailure(Throwable error) {
		logger.info("FAILED: \n" + error.getMessage());
		UtilMessage.showErrorDialogBox(logger, error.getMessage());
	}

	@Override
	public void onSuccess(CommonResponse<List<Category>> response) {
		if (response == null) {
			// TODO
		}

		if (RequestStatus.ERROR.equals(response.getStatus().getRequestStatus())) {
			final DialogBox serverErrorDgBox = new DialogBox();

			VerticalPanel serverErrorVertPanel = new VerticalPanel();
			Label serveErrorLabel = new Label("Error occured!");

			ClickHandler serveErrorButtonHandler = new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					serverErrorDgBox.hide();
				}
			};
			Button serveErrorButton = new Button("Ok", serveErrorButtonHandler);

			serverErrorVertPanel.add(serveErrorLabel);
			serverErrorVertPanel.add(serveErrorButton);
			serverErrorVertPanel.setCellHorizontalAlignment(serveErrorLabel, HasHorizontalAlignment.ALIGN_CENTER);
			serverErrorVertPanel.setCellHorizontalAlignment(serveErrorButton, HasHorizontalAlignment.ALIGN_CENTER);
			serverErrorDgBox.setWidget(serverErrorVertPanel);

			serverErrorDgBox.center();
			serverErrorDgBox.setAnimationEnabled(true);
			serverErrorDgBox.setGlassEnabled(true);
			serverErrorDgBox.show();
		}
		logger.info("QueryCategories response status: SUCCESS");

		for (Category category : response.getContent()) {
			HorizontalPanel categotriesPanel = new HorizontalPanel();

			for (String productTypeName : category.getNames()) {
				Anchor productTypeAnchor = new Anchor(productTypeName);
				categotriesPanel.add(productTypeAnchor);
			}
			categotiesTabBar.add(categotriesPanel, category.getTitle());
		}
	}

	public AsyncCallback<CommonResponse<List<Category>>> addCategotiesTabBar(TabPanel categotiesTabBar) {
		this.categotiesTabBar = categotiesTabBar;
		return this;
	}
}
