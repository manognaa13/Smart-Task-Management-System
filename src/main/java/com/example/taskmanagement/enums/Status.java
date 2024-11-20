package com.example.taskmanagement.enums;

/**
 * enumeration representing the possible statuses of a task.
 * 
 * this enum defines three statuses that a task can have:
 * 
 * 1. PENDING: The task has been created but is not yet in progress. 2.
 * IN_PROGRESS: The task is currently being worked on. 3. COMPLETED: The task
 * has been finished.
 * 
 * this enum can be used to track the state of tasks in a task management system
 * application.
 */
public enum Status {
	PENDING, // Task is created but not started
	IN_PROGRESS, // Task is currently being worked on
	COMPLETED // Task has been completed
}