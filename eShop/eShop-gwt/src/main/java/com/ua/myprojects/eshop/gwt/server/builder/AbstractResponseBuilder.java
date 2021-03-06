package com.ua.myprojects.eshop.gwt.server.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.inject.Inject;

import com.ua.myprojects.eshop.gwt.shared.model.CommonResponse;
import com.ua.myprojects.eshop.gwt.shared.model.MessageData;
import com.ua.myprojects.eshop.gwt.shared.model.RequestStatus;
import com.ua.myprojects.eshop.gwt.shared.model.StatusData;
import com.ua.myprojects.eshop.service.model.MessageCode;

public abstract class AbstractResponseBuilder<T> implements ResponseBuilder<T> {
	private StatusData status;
	private T content;

	@Inject
	private MessageData messageData;

	@Override
	public ResponseBuilder<T> addStatus(RequestStatus reqStatus) {
		if (status == null) {
			status = new StatusData();
		}
		status.setRequestStatus(reqStatus);
		return this;
	}

	@Override
	public ResponseBuilder<T> addMessageData(MessageCode code, String... values) {
		if (status == null) {
			status = new StatusData();
		}
		List<MessageData> messageDatas = status.getMessageDatas();
		if (CollectionUtils.isEmpty(messageDatas)) {
			messageDatas = new ArrayList<MessageData>();
			status.setMessageDatas(messageDatas);
		}
		messageData.populateMsgCode(code.getMsgCode());
		messageData.populateMsgValues(values);
		messageDatas.add(messageData);

		return this;

	}

	@Override
	public ResponseBuilder<T> addMessageDatas(List<MessageData> messageDatas) {
		if (status == null) {
			status = new StatusData();
		}
		status.setMessageDatas(messageDatas);
		return this;
	}

	@Override
	public ResponseBuilder<T> addContent(T content) {
		this.content = content;
		return this;
	}

	@Override
	public abstract CommonResponse<T> build();

	protected StatusData getStatus() {
		return status;
	}

	protected T getContent() {
		return content;
	}

}
