package com.ua.myprojects.eshop.gwt.server.builder;

import com.ua.myprojects.eshop.gwt.shared.model.CommonResponse;

public class CommonResponseBuilder<T> extends AbstractResponseBuilder<T> {

	@Override
	public CommonResponse<T> build() {
		CommonResponse<T> resposne = new CommonResponse<T>();
		resposne.setContent(getContent());
		resposne.setStatus(getStatus());
		return resposne;
	}

}
