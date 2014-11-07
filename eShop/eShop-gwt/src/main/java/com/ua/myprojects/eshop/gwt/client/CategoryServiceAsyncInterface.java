package com.ua.myprojects.eshop.gwt.client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.ua.myprojects.eshop.service.model.Category;

@Path("/categories")
public interface CategoryServiceAsyncInterface {
	@GET
	@Produces("application/json")
	List<Category> queryCategories(AsyncCallback<List<Category>> list);
}
