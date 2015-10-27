package com.ua.myprojects.eshop.builder;

import java.util.List;

import javax.inject.Inject;

import com.ua.myprojects.eshop.service.model.CommonResponse;
import com.ua.myprojects.eshop.service.model.MessageCode;
import com.ua.myprojects.eshop.service.model.MessageData;
import com.ua.myprojects.eshop.service.model.RequestStatus;
import com.ua.myprojects.eshop.service.model.StatusData;
import com.ua.myprojects.eshop.service.util.MessageTextUtil;

public abstract class AbstractResponseBuilder<T> implements ResponseBuilder<T> {

	@Inject
	private MessageTextUtil messageTextUtil;

	abstract protected CommonResponse<T> buildResponse();

	abstract protected CommonResponse<T> getResposne();

	@Override
	public ResponseBuilder<T> addStatus(RequestStatus reqStatus) {
		buildResponse().getStatus().setRequestStatus(reqStatus);
		return this;
	}

	@Override
	public ResponseBuilder<T> addMessageData(MessageCode code, String... values) {
		List<MessageData> messageDatas = getResposne().getStatus().getMessageDatas();
		MessageData messageData = new MessageData();
		messageData.setMsgCode(code.getMsgCode());
		messageData.setMsgText(messageTextUtil.getMessageCode(code.getMsgCode()));
		messageData.populateMsgValues(values);
		messageDatas.add(messageData);

		return this;
	}

	@Override
	public ResponseBuilder<T> addMessageDatas(List<MessageData> messageDatas) {
		getResposne().getStatus().setMessageDatas(messageDatas);
		return this;
	}

	@Override
	public ResponseBuilder<T> addContent(T content) {
		getResposne().setContent(content);
		return this;
	}

	@Override
	public abstract CommonResponse<T> build();

	protected StatusData getStatus() {
		return getResposne().getStatus();
	}

	protected T getContent() {
		return getResposne().getContent();
	}

}
