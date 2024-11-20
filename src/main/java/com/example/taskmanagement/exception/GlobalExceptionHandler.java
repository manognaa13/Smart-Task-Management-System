package com.example.taskmanagement.exception;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<TaskErrorResponse> handleTaskNotFoundException(TaskNotFoundException notFoundException) {
		TaskErrorResponse errorResponse = new TaskErrorResponse();
		
		errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
		errorResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setResponseMessage(notFoundException.getMessage());
		errorResponse.setTimeStamp(LocalDateTime.now(ZoneId.systemDefault()));
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUUIDFormatException.class)
	public ResponseEntity<TaskErrorResponse> handleInvalidUUIDFormatException(InvalidUUIDFormatException invalidUUIDFormatException) {
		TaskErrorResponse errorResponse = new TaskErrorResponse();
		
		errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setResponseMessage(invalidUUIDFormatException.getMessage());
		errorResponse.setTimeStamp(LocalDateTime.now(ZoneId.systemDefault()));
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
	
	@ExceptionHandler(value = {NoResourceFoundException.class})
    public final ResponseEntity<Map<String, Object>> handleNoResourceFoundException(
            NoResourceFoundException noResourceFoundException, HttpServletRequest request) {
		TaskErrorResponse response = new TaskErrorResponse();
		response.setHttpStatus(HttpStatus.NOT_FOUND);
		response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		response.setResponseMessage("Static Resource Could not be found on the Server.");
		response.setTimeStamp(LocalDateTime.now(ZoneId.systemDefault()));
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("response", response);
        errorDetails.put("message", "The requested resource could not be found on the server. Please check the resource URL and try again.");
        errorDetails.put("errorDetails", noResourceFoundException.getLocalizedMessage());
        errorDetails.put("Requested URL", request.getRequestURI().toString());
        errorDetails.put("Requested URL", request.getRequestURL().toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> error = Map.of("error", "An unexpected error occurred : " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}	