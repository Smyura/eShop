package com.ua.myprojects.eshop.service.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
//@JsonInclude(Include.NON_NULL)
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
