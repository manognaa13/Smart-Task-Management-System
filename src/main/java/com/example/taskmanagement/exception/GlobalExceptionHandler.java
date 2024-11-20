package com.example.taskmanagement.exception;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public final ResponseEntity<Map<String, Object>> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException 
			httpRequestMethodNotSupportedException, HttpServletRequest httpServletRequest) {
		TaskErrorResponse response = new TaskErrorResponse(
				HttpStatus.METHOD_NOT_ALLOWED,
				HttpStatus.METHOD_NOT_ALLOWED.value(),
				httpRequestMethodNotSupportedException.getLocalizedMessage().toString(),
				LocalDateTime.now(ZoneId.systemDefault()));
		Map<String, Object> errors = new HashMap<>();
		errors.put("response", response);
		errors.put("Requested URL", httpServletRequest.getRequestURI().toString());
		errors.put("Requested URL", httpServletRequest.getRequestURL().toString());
		errors.put("Supported Methods", httpRequestMethodNotSupportedException.getSupportedHttpMethods().toString());
		return new
				ResponseEntity<>(errors,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(TaskNotFoundException.class)
	public final ResponseEntity<TaskErrorResponse> handleTaskNotFoundException(TaskNotFoundException notFoundException) {
		TaskErrorResponse errorResponse = new TaskErrorResponse(
				HttpStatus.NOT_FOUND,
				HttpStatus.NOT_FOUND.value(),
				notFoundException.getLocalizedMessage().toString(),
				LocalDateTime.now(ZoneId.systemDefault()));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUUIDFormatException.class)
	public final ResponseEntity<TaskErrorResponse> handleInvalidUUIDFormatException(InvalidUUIDFormatException invalidUUIDFormatException) {
		TaskErrorResponse errorResponse = new TaskErrorResponse(
				HttpStatus.BAD_REQUEST,
				HttpStatus.BAD_REQUEST.value(),
				invalidUUIDFormatException.getLocalizedMessage().toString(),
				LocalDateTime.now(ZoneId.systemDefault()));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex,
    		HttpServletRequest request) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("httpStatus", HttpStatus.BAD_REQUEST);
        errors.put("httpStatusCode", HttpStatus.BAD_REQUEST.value());
        errors.put("timeStamp", LocalDateTime.now(ZoneId.systemDefault()));
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
	
	@ExceptionHandler(NoResourceFoundException.class)
    public final ResponseEntity<Map<String, Object>> handleNoResourceFoundException(
            NoResourceFoundException noResourceFoundException, HttpServletRequest request) {
		TaskErrorResponse response = new TaskErrorResponse(
				HttpStatus.NOT_FOUND,
				HttpStatus.NOT_FOUND.value(),
				noResourceFoundException.getLocalizedMessage().toString(),
				LocalDateTime.now(ZoneId.systemDefault()));
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("response", response);
        errorDetails.put("message", "The requested Static Resource could not be found on the server. Please check the resource URL and try again.");
        errorDetails.put("Requested URL", request.getRequestURI().toString());
        errorDetails.put("Requested URL", request.getRequestURL().toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public final ResponseEntity<Map<String, Object>> handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException, 
			HttpServletRequest request) {
		TaskErrorResponse response = new TaskErrorResponse(
				HttpStatus.BAD_REQUEST, 
				HttpStatus.BAD_REQUEST.value(), 
				httpMessageNotReadableException.getLocalizedMessage().toString(),
				LocalDateTime.now(ZoneId.systemDefault()));
		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("response", response);
        errorDetails.put("Requested URL", request.getRequestURI().toString());
        errorDetails.put("Requested URL", request.getRequestURL().toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public final ResponseEntity<Map<String, Object>> handleMissingServletRequestParameterException(MissingServletRequestParameterException missingServletRequestParameterException, 
			HttpServletRequest request) {
		TaskErrorResponse response = new TaskErrorResponse(
				HttpStatus.BAD_REQUEST,
				HttpStatus.BAD_REQUEST.value(),
				missingServletRequestParameterException.getLocalizedMessage().toString(),
				LocalDateTime.now(ZoneId.systemDefault()));
		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("response", response);
		errorDetails.put("Requested URL", request.getRequestURI().toString());
        errorDetails.put("Requested URL", request.getRequestURL().toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> error = Map.of("error", "An unexpected error occurred : " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}	