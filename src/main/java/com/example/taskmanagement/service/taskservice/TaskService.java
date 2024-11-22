package com.example.taskmanagement.service.taskservice;

/**
 * service interface for managing tasks.
 * 
 * This interface defines the operations that can be performed on tasks,
 * including retrieving, creating, updating, and deleting tasks. 
 * It also includes a method to mark a task as completed.
 */
import java.util.List;
import java.util.Optional;

import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.dto.createtask.CreateTaskDTO;
import com.example.taskmanagement.dto.createtask.CreateTaskResponse;
import com.example.taskmanagement.dto.updatetask.UpdateTaskDTO;
import com.example.taskmanagement.dto.updatetask.UpdateTaskResponse;
import com.example.taskmanagement.enums.Status;
import com.example.taskmanagement.model.Task;

public interface TaskService {

	/**
	 * Retrieves all tasks.
	 * 
	 * @return a list of @TaskDTO objects representing all tasks
	 */
	abstract List<TaskDTO> getAllTasks();

	/**
	 * Retrieves a task by its ID.
	 * 
	 * @param id - the id of the task to retrieve
	 * @return an @Optional containing the @TaskDTO if found, or empty if not
	 */
	abstract Optional<TaskDTO> getTaskById(String id);

	/**
	 * Creates a new task.
	 * 
	 * @param @CreateTaskRequestDTO - the details of the new task to create
	 * @return a @CreateTaskResponse response @Record object containing details of
	 *         the created task
	 */
	abstract CreateTaskResponse createANewTask(CreateTaskDTO newTaskDTO);

	/**
	 * Updates an existing task.
	 * 
	 * @param id                    - the id of the task to update
	 * @param @UpdateTaskRequestDTO the updated task details
	 * @return a @UpdateTaskResponse response @Record object containing details of
	 *         the updated task
	 */
	abstract UpdateTaskResponse updateAnExistingTask(String id, UpdateTaskDTO updatedTask);

	/**
	 * Deletes an existing task by its id.
	 * 
	 * @param id - the id of the task to delete
	 */
	abstract void deleteAnExistingTask(String id);

	/**
	 * Marks a task as completed.
	 * 
	 * @param id - the id of the task to mark as completed
	 * @return the updated @TaskDTO representing the completed task
	 */
	abstract TaskDTO markTaskAsCompleted(String id);
	
	/**
	 * Get a @Task by @Status
	 * 
	 * @param status - the status of the task
	 * @return a @List of @Task tasks
	 */
	abstract List<Task> getTasksByStatus(Status status);
}