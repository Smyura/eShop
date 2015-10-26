package com.ua.myprojects.eshop.gwt.client.util;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UtilMessage {
	public static void showErrorDialogBox(Logger logger, String expMessage) {
		logger.info(expMessage);
		final DialogBox serverErrorDgBox = new DialogBox();

		VerticalPanel serverErrorVertPanel = new VerticalPanel();
		Label serveErrorLabel = new Label(expMessage);

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
}
