package com.example.learning;

public class BusinessException extends RuntimeException {
	
	String code;
	String message;
	public BusinessException(String code,String message){
		super(message);

		this.code=code;
		this.message=message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
