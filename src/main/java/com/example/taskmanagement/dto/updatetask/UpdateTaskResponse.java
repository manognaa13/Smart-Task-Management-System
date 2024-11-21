package com.example.taskmanagement.dto.updatetask;

/**
 * a response DTO for updating a task.
 * this record encapsulates the updated details of the task
 * & returns back as a updated task response.
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
public record UpdateTaskResponse(String id, String title, String description, String status, String dueDate) {
}
