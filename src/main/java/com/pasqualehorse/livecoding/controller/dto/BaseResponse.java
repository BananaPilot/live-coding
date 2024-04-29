package com.pasqualehorse.livecoding.controller.dto;

public class BaseResponse {

	private BaseResponseStatus status = BaseResponseStatus.OK;
	private String errorMessage;

	public BaseResponse() {}
	
	public BaseResponse(String errorMessage) {
		this.errorMessage = errorMessage;
		this.status = BaseResponseStatus.KO;
	}
	
	
	public BaseResponseStatus getStatus() {
		return status;
	}

	public void setStatus(BaseResponseStatus status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public enum BaseResponseStatus {
		OK, KO;
	}
}
