package com.example.taskmanagement.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * data transfer object for @Task entity. this DTO is used for transferring task
 * data between the application layers.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

	private String id; // unique identifier for the task

	@NotNull(message = "Title must not be Null")
	@NotEmpty(message = "Title must not be Empty")
	@NotBlank(message = "Title is mandatory")
	@Size(min = 10, max = 60, message = "Title must be atleast 10 characters " + "& must not exceed 60 characters.")
	@JsonProperty(required = true)
	private String title; // Title of the task

	@NotNull(message = "Description must not be Null")
	@NotEmpty(message = "Description must not be Empty")
	@NotBlank(message = "Description is mandatory")
	@Size(min = 25, max = 255, message = "Description must be atleast 25 characters "
			+ "& must not exceed 255 characters.")
	@JsonProperty(required = true)
	private String description; // description of the task

	@Future(message = "Date must be in the Future.")
	@JsonProperty(access = Access.READ_WRITE, required = true)
	private String dueDate; // Due date of the task

	private String status; // current status of the task (e.g., "Pending", "In_Progress", "Completed")

	/**
	 * Will be Ignored in API Response
	 */
	@JsonIgnore
	@JsonProperty(access = Access.READ_WRITE)
	private LocalDateTime taskCreatedAt;

	/**
	 * Will be Ignored in API Response
	 */
	@JsonIgnore
	@JsonProperty(access = Access.READ_WRITE)
	private LocalDateTime taskUpdatedAt;

	/**
	 * constructor for a @TaskDTO without timestamps. this can be useful when
	 * retrieving tasks form database.
	 *
	 * @param id          unique identifier for the task
	 * @param title       Title of the task
	 * @param description description of the task
	 * @param dueDate     Due date of the task
	 * @param status      current status of the task
	 */
	public TaskDTO(String id, String title, String description, String dueDate, String status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
	}
}