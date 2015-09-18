package com.ua.myprojects.eshop.dao;

public enum ConnectionType {
	JDBC("jdbc");

	private String type;

	private ConnectionType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
