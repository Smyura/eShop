package com.ua.myprojects.eshop.service.model;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;

public class MessageData {
	private String msgCode;
	private String msgText;
	private List<String> msgValues;

	@Resource(name = "messageTextProperties")
	private Properties messageText;

	public String getMsgCode() {
		return msgCode;
	}

	public void populateMsgCode(String msgCode) {
		this.msgText = messageText.getProperty(msgCode);
		this.msgCode = msgCode;
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
