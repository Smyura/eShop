package com.ua.myprojects.eshop.service.model;

public class CommonResponse<T> {
	private StatusData status;
	private T content;

	public CommonResponse() {
		status = new StatusData();
	}

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
