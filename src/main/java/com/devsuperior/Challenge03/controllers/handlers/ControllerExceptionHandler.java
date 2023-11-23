package com.devsuperior.challenge03.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.challenge03.dto.RequestErrorCustom;
import com.devsuperior.challenge03.services.exceptions.DataBaseException;
import com.devsuperior.challenge03.services.exceptions.SearchNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(SearchNotFoundException.class)
	public ResponseEntity<RequestErrorCustom> searchNotFound(SearchNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		RequestErrorCustom error = new RequestErrorCustom(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<RequestErrorCustom> dataBaseError(DataBaseException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		RequestErrorCustom error = new RequestErrorCustom(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
}
