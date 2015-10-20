package com.ua.myprojects.eshop.service.model;

import java.util.List;

public class StatusData {
	private RequestStatus requestStatus;
	private List<MessageData> messageDatas;

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public List<MessageData> getMessageDatas() {
		return messageDatas;
	}

	public void setMessageDatas(List<MessageData> messageDatas) {
		this.messageDatas = messageDatas;
	}

}