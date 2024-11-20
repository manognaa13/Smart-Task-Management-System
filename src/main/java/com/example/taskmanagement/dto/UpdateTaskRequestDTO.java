package com.example.taskmanagement.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateTaskRequestDTO {
	
	@Size(min = 10, max = 60, message = "Title must be atleast 10 characters "
			+ "& must not exceed 60 characters.")
	@JsonProperty(access = Access.READ_WRITE)
	@Nullable
	private String title;
	
	@Size(min = 25, max = 255, message = "Description must be atleast 25 characters "
			+ "& must not exceed 255 characters.")
	@JsonProperty(access = Access.READ_WRITE)
	@Nullable
	private String description;
	
	@Future(message = "Date must be in the Future.")
	@JsonProperty(access = Access.READ_WRITE)
	@Nullable
	private LocalDate dueDate;
}