package com.ua.myprojects.eshop.gwt.shared.model;

import java.io.Serializable;
import java.util.List;

public class StatusData implements Serializable {
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
