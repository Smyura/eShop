package com.ua.myprojects.eshop.service.model;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

public class MessageData {
	private String msgCode;
	private String msgText;
	private List<String> msgValues;

	// @Resource(name = "messageTextProperties")
	// private Properties messageText;

	public String getMsgCode() {
		return msgCode;
	}

	public List<String> getMsgValues() {
		return msgValues;
	}

	public void populateMsgValues(String... msgValues) {
		if (msgValues == null || msgValues.length == 0) {
			return;
		}
		if (ArrayUtils.isEmpty(ArrayUtils.removeElement(msgValues, (String) null))) {
			this.msgValues = Arrays.asList();
		} else {
			this.msgValues = Arrays.asList(msgValues);
		}
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	public void setMsgValues(List<String> msgValues) {
		this.msgValues = msgValues;
	}

	public String getMsgText() {
		return msgText;
	}

}
