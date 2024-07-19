package com.aven.aspects;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aven.dto.ApiError;
import com.aven.exceptions.ApplicationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity <ApiError>  handle(Exception e) {
		ApiError error = new ApiError(e.getMessage());
		return new ResponseEntity<ApiError>(error, HttpStatusCode.valueOf(404));
	}
}
