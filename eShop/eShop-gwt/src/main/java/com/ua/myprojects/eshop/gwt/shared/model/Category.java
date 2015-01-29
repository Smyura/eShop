package com.ua.myprojects.eshop.gwt.shared.model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private List<String> names;

	public Category() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

}
