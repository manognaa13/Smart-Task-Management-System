package com.example.taskmanagement.exceptionhandler.customexception;

/**
 * Custom exception class to handle invalid @UUID format errors.
 */
public class InvalidUUIDFormatException extends RuntimeException {

	private static final long serialVersionUID = 6946666981705161746L;

	/**
     * Constructs a new @InvalidUUIDFormatException with the specified detail message.
     *
     * @param message - the detail message which is saved for later retrieval by the getMessage() method.
     */
	public InvalidUUIDFormatException(String message) {
		super(message);
	}

	/**
     * Constructs a new @InvalidUUIDFormatException with the specified detail message and cause.
     *
     * @param message - the detail message (which is saved for later retrieval by the getMessage() method).
     * @param cause - the cause (which is saved for later retrieval by the getCause() method).
     */
	public InvalidUUIDFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
     * Constructs a new @InvalidUUIDFormatException with the specified cause.
     *
     * @param cause - the cause (which is saved for later retrieval by the getCause() method).
     */
	public InvalidUUIDFormatException(Throwable cause) {
		super(cause);
	}
}
