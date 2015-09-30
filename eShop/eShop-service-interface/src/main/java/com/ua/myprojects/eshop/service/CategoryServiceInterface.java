package com.ua.myprojects.eshop.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.ua.myprojects.eshop.service.model.Category;
import com.ua.myprojects.eshop.service.model.CommonResponse;

@Path("/categories")
public interface CategoryServiceInterface {
	@GET
	@Produces("application/json")
	CommonResponse<List<Category>> queryProductCategories();
}
