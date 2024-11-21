package com.example.taskmanagement.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.dto.createtask.CreateTaskDTO;
import com.example.taskmanagement.dto.createtask.CreateTaskResponse;
import com.example.taskmanagement.dto.updatetask.UpdateTaskDTO;
import com.example.taskmanagement.dto.updatetask.UpdateTaskResponse;
import com.example.taskmanagement.service.taskservice.TaskService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

	private TaskService taskService;

	/**
	 * @Constructor for @TaskController
	 * 
	 * @param service - the @TaskService to be used for task operations
	 */
	public TaskController(TaskService service) {
		this.taskService = service;
	}

	/**
	 * Retrieve all tasks.
	 *
	 * @return a list of @TaskDTO representing all tasks.
	 */
	@GetMapping
	public List<TaskDTO> getAllTasks() {
		logger.info("Fetching all tasks");
		return taskService.getAllTasks();
	}

	/**
	 * Retrieve a task by its id
	 *
	 * @param id - the id of the task to retrieve.
	 * @return @ResponseEntity containing the @TaskDTO if found, otherwise
	 *         a @HttpStatus.NOT_FOUND status.
	 */
	@GetMapping("/id")
	public ResponseEntity<TaskDTO> getTaskById(@RequestParam String id) {
		logger.info("Fetching task with ID: {} ", id);
		return taskService.getTaskById(id).map(ResponseEntity::ok).orElseGet(() -> {
			logger.warn("Task with ID: {} not found ", id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		});
	}

	/**
	 * Create a new task.
	 *
	 * @param @TaskRequestDTO the task data to create.
	 * @return @ResponseEntity containing the @CreateTaskResponse created task
	 *         response.
	 */
	@PostMapping
	public ResponseEntity<CreateTaskResponse> createTask(@Valid @RequestBody CreateTaskDTO taskRequestDTO) {
		logger.info("Creating a new task with details: {} ", taskRequestDTO);
		CreateTaskResponse response = taskService.createANewTask(taskRequestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	/**
	 * Delete a task by its id
	 *
	 * @param id - the id of the task to delete.
	 * @return @ResponseEntity containing a @HttpStatus.ACCEPTED message.
	 */
	@DeleteMapping("/id")
	public ResponseEntity<Map<String, String>> deleteTask(@RequestParam String id) {
		logger.info("Deleting task with ID: {} ", id);
		taskService.deleteAnExistingTask(id);
		Map<String, String> response = Map.of("Message", "Task has been Deleted Successfully.", "id", id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	/**
	 * mark a task as completed.
	 *
	 * @param id - the id of the task to mark as completed.
	 * @return @ResponseEntity containing a success OK message and the updated task.
	 */
	@PatchMapping("/id")
	public ResponseEntity<Map<String, Object>> markTaskAsComplete(@RequestParam String id) {
		logger.info("Marking task with ID: {} as completed", id);
		TaskDTO dto = taskService.markTaskAsCompleted(id);
		Map<String, Object> response = Map.of("Message", "Task has been Marked as Completed Successfully.", "task",
				dto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	/**
	 * update an existing task.
	 *
	 * @param id                   - the id of the task to update.
	 * @param @UpdateaskRequestDTO to update the existing task data.
	 * @return @ResponseEntity containing the updated task response.
	 */
	@PutMapping("/id")
	public ResponseEntity<UpdateTaskResponse> updateTask(@RequestParam String id,
			@Valid @RequestBody UpdateTaskDTO requestDTO) {
		logger.info("Updating task with ID: {} with new details: {} ", id, requestDTO);
		return ResponseEntity.ok(taskService.updateAnExistingTask(id, requestDTO));
	}
}