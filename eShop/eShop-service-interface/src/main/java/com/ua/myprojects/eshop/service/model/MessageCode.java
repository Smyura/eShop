package com.ua.myprojects.eshop.service.model;

public enum MessageCode {
	ESHOPDB0xx_DB_CONNECTION_ERROR("ESHOPDB000"), ESHOPDB0xx_MISSING_DB_DATA("ESHOPDB001"), ESHOPDB0xx_FETCHING_DB_DATA_ERROR(
			"ESHOPDB002"), OTHER("ESHOPOTHER");

	private final String msgCode;

	private MessageCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public static MessageCode fromValue(String code) {
		if (code != null) {
			for (MessageCode currentCode : values()) {
				if (currentCode.msgCode.contains(code)) {
					return currentCode;
				}
			}
		}
		return OTHER;
	}

	public String getMsgCode() {
		return msgCode;
	}

}
