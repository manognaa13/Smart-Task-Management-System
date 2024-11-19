package com.example.taskmanagement.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.example.taskmanagement.model.Status;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
	
	private UUID id;
	
	@NotNull(message = "Title must not be Null")
	@NotEmpty(message = "Title must not be Empty")
	@NotBlank(message = "Title is mandatory")
	@Size(min = 10, max = 60, message = "Description must be atleast 10 characters "
			+ "& must not exceed 60 characters.")
	@JsonProperty(required = true)
	private String title;
	
	@NotNull(message = "Description must not be Null")
	@NotEmpty(message = "Description must not be Empty")
	@NotBlank(message = "Description is mandatory")
	@Size(min = 25, max = 255, message = "Description must be atleast 25 characters "
			+ "& must not exceed 255 characters.")
	@JsonProperty(required = true)
	private String description;
	
	@Future(message = "Date must be in the Future.")
	@JsonProperty(access = Access.READ_WRITE, required = true)
	private LocalDate dueDate;
	
	private Status status;
	
	@JsonIgnore
	@JsonProperty(access = Access.READ_WRITE)
	private LocalDateTime taskCreatedAt;
	
	@JsonIgnore
	@JsonProperty(access = Access.READ_WRITE)
	private LocalDateTime taskUpdatedAt;
	
	public TaskDTO(UUID id,
				String title, 
				String description, 
				LocalDate dueDate, 
				Status status) {
		this.id=id;
		this.title=title;
		this.description=description;
		this.dueDate=dueDate;
		this.status=status;
	}
}