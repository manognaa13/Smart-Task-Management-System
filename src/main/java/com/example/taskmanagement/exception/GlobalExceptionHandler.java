package com.example.taskmanagement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<TaskErrorResponse> handleTaskNotFoundException(TaskNotFoundException notFoundException) {
		TaskErrorResponse errorResponse = new TaskErrorResponse();
		
		errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
		errorResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setResponseMessage(notFoundException.getMessage());
		errorResponse.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}	