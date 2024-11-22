package com.example.taskmanagement.service.utilities;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.taskmanagement.exceptionhandler.customexception.InvalidUUIDFormatException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component(value = "UUIDConverter")
/**
 * utility classes generally contain static methods or static variables & do not
 * need spring’s dependency injection or lifecycle management.
 * 
 * Using @Component on a utility class is unnecessary because it does not need
 * to be instantiated or managed by spring.
 */
public final class UUIDConverter {

	private static final Logger logger = LoggerFactory.getLogger(UUIDConverter.class);

	/**
	 * converts a string representation of a string uuid to a @UUID object.
	 * 
	 * @param id - the string representation of the @UUID
	 * @return the @UUID object corresponding to the string
	 * @throws @InvalidUUIDFormatException if the input string is null or not in the
	 *                                     valid @UUID format
	 */
	public static final UUID stringToUUIDConverter(String id) {
		logger.debug("Starting Conversion of String to UUID: {} ", id);
		// Check if the input string is null or does not match the UUID format
		if (id == null
				|| !id.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")) {
			logger.error("Invalid UUID Format: {} ", id);
			throw new InvalidUUIDFormatException("Invalid UUID Format: " + id);
		}
		// Convert the valid string to a UUID object
		UUID uuid = UUID.fromString(id);
		logger.debug("Successfully Converted string to UUID: {} ", uuid);
		return uuid;
	}
}