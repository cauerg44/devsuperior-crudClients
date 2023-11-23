package com.devsuperior.challenge03.services.exceptions;

public class DataBaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DataBaseException(String advice) {
		super(advice);
	}
}
