package com.ua.myprojects.eshop.properties;

public enum EshopProperties {
	JDBC("jdbcProperties");

	private String property;

	private EshopProperties(String propety) {
		this.property = propety;
	}

	public String getPropertyName() {
		return property;
	}

}
