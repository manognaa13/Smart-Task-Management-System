package com.example.taskmanagement.dto;

public record UpdateTaskResponse(
		String id,
		String title,
		String description,
		String status,
		String dueDate
		) {}
