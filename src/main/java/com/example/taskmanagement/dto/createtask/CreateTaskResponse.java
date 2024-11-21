package com.example.taskmanagement.dto.createtask;

/**
 * A response DTO for creating a new task.
 * this record encapsulates the details of the task that has been created.
 */

/**
 * class is defined as a java record, which is a great way to create immutable
 * data carriers in a concise manner
 */

/**
 * records were first introduced in java 14 and finalized in java 16. They
 * represent immutable data carriers that enable the developers to omit a lot of
 * boilerplate code when defining a simple data class. By default, all fields
 * defined in a record class are private and final.
 */
public record CreateTaskResponse(String id, String title, String description, String dueDate, String status) {
}