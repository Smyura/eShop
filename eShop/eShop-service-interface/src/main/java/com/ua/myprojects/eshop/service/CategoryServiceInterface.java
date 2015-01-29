package com.ua.myprojects.eshop.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.ua.myprojects.eshop.service.model.Category;

@Path("/categories")
public interface CategoryServiceInterface {
	@GET
	@Produces("application/json")
	List<Category> queryCategoriesTitles();

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	List<String> queryCategoriesNames(String title);
}
