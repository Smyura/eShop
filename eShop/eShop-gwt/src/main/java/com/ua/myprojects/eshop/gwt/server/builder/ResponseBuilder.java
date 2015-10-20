package com.ua.myprojects.eshop.gwt.server.builder;

import java.util.List;

import com.ua.myprojects.eshop.gwt.shared.model.CommonResponse;
import com.ua.myprojects.eshop.gwt.shared.model.MessageData;
import com.ua.myprojects.eshop.gwt.shared.model.RequestStatus;
import com.ua.myprojects.eshop.service.model.MessageCode;

public interface ResponseBuilder<T> {
	ResponseBuilder<T> addStatus(RequestStatus status);

	ResponseBuilder<T> addMessageData(MessageCode code, String... msgValues);

	ResponseBuilder<T> addMessageDatas(List<MessageData> messageDatas);

	ResponseBuilder<T> addContent(T content);

	CommonResponse<T> build();
}
