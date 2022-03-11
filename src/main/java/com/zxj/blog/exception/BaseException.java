package com.zxj.blog.exception;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -6998687397315108989L;
	private String errorCode;
	private String errorMessage;

	public BaseException() {
		super();
	}

	public BaseException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public BaseException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
