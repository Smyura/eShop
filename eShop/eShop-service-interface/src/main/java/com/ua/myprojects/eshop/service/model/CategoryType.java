package com.ua.myprojects.eshop.service.model;

public enum CategoryType {
	NOTEBOOK("Notebook"), PAD("Pad"), PC("PC"), MOBILE_PHONE("Mobile phone");

	private String name;

	private CategoryType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
