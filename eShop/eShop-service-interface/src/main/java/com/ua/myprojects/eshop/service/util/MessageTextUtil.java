package com.ua.myprojects.eshop.service.util;

import java.util.Properties;

import javax.annotation.Resource;

public class MessageTextUtil {
	@Resource(name = "messageTextProperties")
	private Properties messageText;

	public String getMessageCode(String msgCode) {
		return messageText.getProperty(msgCode);
	}
}
