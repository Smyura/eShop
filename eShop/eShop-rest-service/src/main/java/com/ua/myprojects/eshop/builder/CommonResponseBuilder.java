package com.ua.myprojects.eshop.builder;

import com.ua.myprojects.eshop.service.model.CommonResponse;

public class CommonResponseBuilder<T> extends AbstractResponseBuilder<T> {
	private CommonResponse<T> resposne;

	@Override
	public CommonResponse<T> buildResponse() {
		resposne = new CommonResponse<T>();
		return resposne;
	}

	@Override
	protected CommonResponse<T> getResposne() {
		return resposne;
	}

	@Override
	public CommonResponse<T> build() {
		return resposne;
	}

}
