package com.example.taskmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is the main entry point for the Task Management System Application to Start.
 * Enables asynchronous method execution, allowing methods annotated with to run in a separate thread.
 * Enables support for scheduled tasks, allowing methods annotated with @Scheduled to be executed at fixed intervals or according to cron expressions.
 * It enables asynchronous processing via @link org.springframework.scheduling.annotation.Async @Async
 * and supports scheduled tasks with @link org.springframework.scheduling.annotation.EnableScheduling @EnableScheduling
 */

/**
 * <p>
 * This application utilizes SLF4J for @logging, allowing for flexible @logging
 * configurations and support for various @logging frameworks.
 * </p>
 * <p>
 * 
 * @Logging Levels: - INFO: Used for general application flow and important
 *          events. - DEBUG: Used for detailed debugging information. - WARN:
 *          Used for potentially harmful situations. - ERROR: Used for error
 *          events that might still allow the application to continue running.
 *          </p>
 *          <p>
 *          SLF4J @Logger is initialized for this class to log application
 *          startup events.
 *          </p>
 */

@SpringBootApplication
@EnableAsync
@EnableScheduling
@Slf4j
public class TaskManagementSystemApplication {

	private static final Logger logger = LoggerFactory.getLogger(TaskManagementSystemApplication.class);

	public static void main(String[] args) {
		logger.info("Starting Task Management System Application...");
		SpringApplication.run(TaskManagementSystemApplication.class, args);
		logger.info("Task Management System Application started successfully.");
	}

}