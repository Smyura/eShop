package com.ua.myprojects.eshop.builder;

import java.util.List;

import com.ua.myprojects.eshop.service.model.CommonResponse;
import com.ua.myprojects.eshop.service.model.MessageCode;
import com.ua.myprojects.eshop.service.model.MessageData;
import com.ua.myprojects.eshop.service.model.RequestStatus;

public interface ResponseBuilder<T> {
	ResponseBuilder<T> addStatus(RequestStatus status);

	ResponseBuilder<T> addMessageData(MessageCode code, String... msgValues);

	ResponseBuilder<T> addMessageDatas(List<MessageData> messageDatas);

	ResponseBuilder<T> addContent(T content);

	CommonResponse<T> build();
}
