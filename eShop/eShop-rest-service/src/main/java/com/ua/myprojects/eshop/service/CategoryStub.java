package com.ua.myprojects.eshop.service;

import java.util.ArrayList;
import java.util.List;

import com.ua.myprojects.eshop.service.model.Category;

public class CategoryStub {
	public List<Category> queryCategories() {
		Category category1 = new Category();
		category1.setTitle("Notebooks, Pads, PCs");
		List<String> names1 = new ArrayList<String>();
		names1.add("Notebooks");
		names1.add("Pads");
		names1.add("PCs");
		category1.setNames(names1);

		Category category2 = new Category();
		category2.setTitle("Phones");
		List<String> names2 = new ArrayList<String>();
		names2.add("Mobile phones");
		names2.add("Radio phones");
		category2.setNames(names2);

		Category category3 = new Category();
		category3.setTitle("Home technics");
		List<String> names3 = new ArrayList<String>();
		names3.add("Air conditioners");
		names3.add("Frizers");
		names3.add("TVs");
		category3.setNames(names3);

		List<Category> categories = new ArrayList<Category>();
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);

		return categories;
	}
}
