package com.example.taskmanagement.exceptionhandler.customexception;

/**
 * Custom exception class to handle situations where a task cannot be found.
 */
public class TaskNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8619715290471929628L;

	/**
	 * Constructs a new @TaskNotFoundException with the specified detail message.
	 *
	 * @param message - the detail message which is saved for later retrieval by the
	 *                getMessage() method.
	 */
	public TaskNotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructs a new @TaskNotFoundException with the specified detail message and
	 * cause.
	 *
	 * @param message - the detail message (which is saved for later retrieval by
	 *                the getMessage() method).
	 * @param cause   - the cause (which is saved for later retrieval by the
	 *                getCause() method).
	 */
	public TaskNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new @TaskNotFoundException with the specified cause.
	 *
	 * @param cause - the cause (which is saved for later retrieval by the
	 *              getCause() method).
	 */
	public TaskNotFoundException(Throwable cause) {
		super(cause);
	}
}