package com.ua.myprojects.eshop.gwt.server;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.ua.myprojects.eshop.gwt.server.builder.CommonResponseBuilder;
import com.ua.myprojects.eshop.gwt.server.builder.ResponseBuilder;

public class CategoryServiceModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(ResponseBuilder.class).to(CommonResponseBuilder.class);
	}

}
