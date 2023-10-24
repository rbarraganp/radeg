package com.rbp.radeg.utils.responses;

import java.io.Serializable;

public class RadegResponse<T> implements Serializable {

	private String status;
	private String code;
	private String message;
	private T data;

	private static final long serialVersionUID = 7L;

	public RadegResponse() {
		super();
	}

	public RadegResponse(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public RadegResponse(String status, String code, String message, T data) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
