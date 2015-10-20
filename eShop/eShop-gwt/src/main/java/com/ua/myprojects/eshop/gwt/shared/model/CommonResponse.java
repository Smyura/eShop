package com.ua.myprojects.eshop.gwt.shared.model;

import java.io.Serializable;

public class CommonResponse<T> implements Serializable {
	private StatusData status;
	private T content;

	public StatusData getStatus() {
		return status;
	}

	public void setStatus(StatusData status) {
		this.status = status;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

}
