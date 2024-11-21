package com.example.taskmanagement.dto;

/**
 * a response DTO for updating a task.
 * this record encapsulates the updated details of the task
 * & returns back as a updated task response.
 */

/**
 * class is defined as a java record, which is a great way to create immutable
 * data carriers in a concise manner
 */
public record UpdateTaskResponse(String id, String title, String description, String status, String dueDate) {
}
