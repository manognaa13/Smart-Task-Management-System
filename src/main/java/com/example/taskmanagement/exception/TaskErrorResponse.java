package com.example.taskmanagement.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskErrorResponse implements Serializable {
	
	private static final long serialVersionUID = 5737285503669998642L;
	
	private HttpStatus httpStatus;
	private Integer httpStatusCode;
	private String errorMessage;
	private LocalDateTime timeStamp;
}