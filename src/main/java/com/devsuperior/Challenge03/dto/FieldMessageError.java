package com.devsuperior.challenge03.dto;

public class FieldMessageError {

	private String fieldName;
	private String message;
	
	public FieldMessageError(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	public String getFieldName() {
		return fieldName;
	}
	public String getMessage() {
		return message;
	}
	
	
}
