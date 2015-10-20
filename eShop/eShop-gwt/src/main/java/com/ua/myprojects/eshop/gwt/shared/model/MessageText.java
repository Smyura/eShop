package com.ua.myprojects.eshop.gwt.shared.model;

public enum MessageText {

	ESHOPDB000("Can't connect to DB server: %A1:%A2"), ESHOPDB001("Missing DB data: %A1%"), ESHOPDB002(
			"Can't fetch %A1% from DB"), ESHOPOTHER("Unknown error occurred!");

	private String text;

	private MessageText(String text) {
		this.text = text;
	}

	private String getText() {
		return text;
	}

	public static String getText(String code) {
		for (MessageText messageText : MessageText.values()) {
			if (messageText.toString().equals(code)) {
				return messageText.getText();
			}
		}
		return null;
	}

}
