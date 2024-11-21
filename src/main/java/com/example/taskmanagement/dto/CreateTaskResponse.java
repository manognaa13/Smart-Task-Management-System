package com.example.taskmanagement.dto;

/**
 * A response DTO for creating a new task.
 * this record encapsulates the details of the task that has been created.
 */

/**
 * class is defined as a java record, which is a great way to create immutable
 * data carriers in a concise manner
 */
public record CreateTaskResponse(String id, String title, String description, String dueDate, String status) {
}