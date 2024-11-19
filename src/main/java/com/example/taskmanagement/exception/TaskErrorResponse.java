package com.example.taskmanagement.exception;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskErrorResponse implements Serializable {
	
	private static final long serialVersionUID = 5737285503669998642L;
	
	private org.springframework.http.HttpStatus HttpStatus;
	private Integer httpStatusCode;
	private String responseMessage;
	private LocalDateTime timeStamp;
}