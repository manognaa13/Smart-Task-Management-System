package com.example.taskmanagement.exception;

public class TaskNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -8619715290471929628L;
	
	public TaskNotFoundException(String message) {
        super(message);
    }

    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskNotFoundException(Throwable cause) {
        super(cause);
    }
}