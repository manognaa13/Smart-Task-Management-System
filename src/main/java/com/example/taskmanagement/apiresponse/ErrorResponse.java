package com.example.taskmanagement.apiresponse;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents an error response that is returned to the client when an error
 * occurs.
 */
@Data
@AllArgsConstructor
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 5737285503669998642L;

	/**
	 * The @HttpStatus status associated with the error.
	 */
	private HttpStatus httpStatus;

	/**
	 * The numeric @HttpStatus status code associated with the error.
	 */
	private Integer httpStatusCode;
	
	/**
     * A descriptive error message providing details about the error.
     */
	private String errorMessage;
	
	/**
     * The timestamp when the error occurred.
     */
	private LocalDateTime timeStamp;
	
	/**
     * @AllArgsConstructor for creating a @TaskErrorResponse with the current timestamp.
     *
     * @param httpStatus - The Http status associated with the error.
     * @param errorMessage - A descriptive error message.
     */
}