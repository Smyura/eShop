package com.ua.myprojects.eshop.service.model;

import java.util.ArrayList;
import java.util.List;

public class Category implements Comparable<Category> {
	private int priority;
	private String title;
	private List<String> names;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getNames() {
		if (names == null) {
			names = new ArrayList<String>();
		}
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public int compareTo(Category category) {
		return priority - category.priority;
	}

}
