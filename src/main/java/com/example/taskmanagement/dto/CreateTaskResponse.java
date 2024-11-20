package com.example.taskmanagement.dto;

public record CreateTaskResponse(
		String id,
		String title,
		String description,
		String dueDate,
		String status
) {}