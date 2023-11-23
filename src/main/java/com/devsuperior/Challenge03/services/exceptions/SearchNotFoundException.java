package com.devsuperior.challenge03.services.exceptions;

public class SearchNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public SearchNotFoundException(String advice) {
		super(advice);
	}
}
