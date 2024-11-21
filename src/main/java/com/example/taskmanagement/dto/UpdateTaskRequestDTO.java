package com.example.taskmanagement.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * data transfer object for updating an existing task. this DTO is used to
 * encapsulate the fields that can be updated for a task.
 */
@Data
public class UpdateTaskRequestDTO {

	/**
	 * Title of the task. this class member is optional for updates and must be
	 * between 10 and 60 characters if provided.
	 */
	@Size(min = 10, max = 60, message = "Title must be atleast 10 characters " + "& must not exceed 60 characters.")
	@JsonProperty(access = Access.READ_WRITE)
	@Nullable
	private String title;

	/**
	 * description of the task. this class member is optional for updates and must
	 * be between 25 and 255 characters if provided.
	 */
	@Size(min = 25, max = 255, message = "Description must be atleast 25 characters "
			+ "& must not exceed 255 characters.")
	@JsonProperty(access = Access.READ_WRITE)
	@Nullable
	private String description;

	/**
	 * Due date of the task. this class member is optional for updates and must be
	 * in the @Future if provided.
	 */
	@Future(message = "Date must be in the Future.")
	@JsonProperty(access = Access.READ_WRITE)
	@Nullable
	private LocalDate dueDate;
}