package com.ua.myprojects.eshop.gwt.shared.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class MessageData implements Serializable {
	private String msgCode;
	private String msgText;
	private List<String> msgValues;

	// @Resource(name = "messageTextProperties")
	// private Properties messageText;

	public String getMsgCode() {
		return msgCode;
	}

	public void populateMsgCode(String msgCode) {
		this.msgText = MessageText.getText(msgCode);
		this.msgCode = msgCode;
	}

	public List<String> getMsgValues() {
		return msgValues;
	}

	public void populateMsgValues(String... msgValues) {
		if (msgValues == null || msgValues.length == 0) {
			return;
		}
		if (msgValues == null || msgValues.length == 0) {
			// if (ArrayUtils.isEmpty(ArrayUtils.removeElement(msgValues,
			// (String) null))) {
			this.msgValues = Arrays.asList();
		} else {
			this.msgValues = Arrays.asList(msgValues);
		}
	}

	protected void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	protected void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	protected void setMsgValues(List<String> msgValues) {
		this.msgValues = msgValues;
	}

	public String getMsgText() {
		return msgText;
	}

}
