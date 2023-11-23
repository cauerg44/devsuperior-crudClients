package com.devsuperior.challenge03.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends RequestErrorCustom{

	private List<FieldMessageError> erros = new ArrayList<>();
	
	public ValidationError(Instant timeStamp, Integer status, String error, String path) {
		super(timeStamp, status, error, path);
	}

	public List<FieldMessageError> getErros() {
		return erros;
	}
	
	public void addError(String fieldMessageError, String messageError) {
		erros.add(new FieldMessageError(fieldMessageError, messageError));
	}
	
}
