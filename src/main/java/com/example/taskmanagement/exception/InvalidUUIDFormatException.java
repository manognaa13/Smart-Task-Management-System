package com.example.taskmanagement.exception;

public class InvalidUUIDFormatException extends RuntimeException {

	private static final long serialVersionUID = 6946666981705161746L;
	
	public InvalidUUIDFormatException(String message) {
        super(message);
    }

    public InvalidUUIDFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUUIDFormatException(Throwable cause) {
        super(cause);
    }
}
