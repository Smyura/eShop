package com.ua.myprojects.eshop.builder;

import com.ua.myprojects.eshop.service.model.CommonResponse;

public class CommonResponseBuilder<T> extends AbstractResponseBuilder<T> {

	@Override
	public CommonResponse<T> build() {
		CommonResponse<T> resposne = new CommonResponse<T>();
		resposne.setContent(getContent());
		resposne.setStatus(getStatus());
		return resposne;
	}

}
