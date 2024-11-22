package com.example.taskmanagement.service.impltaskservice;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.dto.createtask.CreateTaskDTO;
import com.example.taskmanagement.dto.createtask.CreateTaskResponse;
import com.example.taskmanagement.dto.updatetask.UpdateTaskDTO;
import com.example.taskmanagement.dto.updatetask.UpdateTaskResponse;
import com.example.taskmanagement.enums.Status;
import com.example.taskmanagement.exceptionhandler.customexception.TaskNotFoundException;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.service.taskservice.TaskService;
import com.example.taskmanagement.service.utilities.UUIDConverter;

import lombok.extern.slf4j.Slf4j;

/**
 * implementation of the @TaskService interface for managing tasks.
 * 
 * This service provides methods to create, retrieve, update, and delete tasks,
 * as well as to mark them as completed. It interacts with the @TaskRepository
 * to perform CRUD operations.
 */
@Service(value = "TaskService")
@Slf4j
public class ITaskService implements TaskService {

	private static final Logger logger = LoggerFactory.getLogger(ITaskService.class);

	private TaskRepository taskRepository;

	/**
	 * @Constructor for @ITaskService
	 * 
	 * @param repository - the @TaskRepository to be used for task operations
	 */
	public ITaskService(TaskRepository repository) {
		this.taskRepository = repository;
	}

	@Override
	public List<Task> getTasksByStatus(Status status) {
		logger.info("Fetching tasks with status: {} ", status);
		List<Task> tasks = taskRepository.findByStatus(status);
		logger.info("Found {} tasks with status: {} ", tasks.size(), status);
		return tasks;
	}

	@Override
	public List<TaskDTO> getAllTasks() {
		logger.info("Retrieving all tasks.");
		return taskRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public Optional<TaskDTO> getTaskById(String id) {
		logger.info("Retrieving task with ID: {} ", id);
		UUID uuid = UUIDConverter.stringToUUIDConverter(id);
		if (!taskRepository.findById(uuid).isPresent()) {
			logger.error("Task Not Found with the given UUID: {} ", id);
			throw new TaskNotFoundException("Task Not Found with the given UUID : " + id);
		}
		return taskRepository.findById(uuid).map(this::convertToDTO);
	}

	@Override
	@Transactional
	@Modifying
	public CreateTaskResponse createANewTask(CreateTaskDTO taskRequestDTO) {
		logger.info("Creating a new task with details: {} ", taskRequestDTO);
		LocalDate dueDate = (taskRequestDTO.getDueDate() != null) ? taskRequestDTO.getDueDate()
				: LocalDate.now().plusDays(7);
		Task task = convertToEntity(taskRequestDTO);
		task.setDueDate(dueDate);
		Task savedTask = taskRepository.save(task);
		logger.info("Task created successfully with ID: {} ", savedTask.getId());
		return convertToCreateTaskResponse(savedTask);
	}

	@Override
	@Transactional
	@Modifying
	public UpdateTaskResponse updateAnExistingTask(String id, UpdateTaskDTO updatedTaskDTO) {
		logger.info("Updating task with ID: {} ", id);
		UUID uuid = UUIDConverter.stringToUUIDConverter(id);
		return taskRepository.findById(uuid).map(existingTask -> {
			updateTaskFromDTO(existingTask, updatedTaskDTO);
			Task updatedTask = taskRepository.save(existingTask);
			logger.info("Task updated successfully with ID: {} ", updatedTask.getId());
			return convertToUpdateTaskResponse(updatedTask);
		}).orElseThrow(() -> {
			logger.error("Task Not Found with the given UUID: {} ", id);
			return new TaskNotFoundException("Task Not Found with the given UUID: " + id);
		});
	}

	@Override
	@Transactional
	@Modifying
	public void deleteAnExistingTask(String id) {
		logger.info("Deleting task with ID: {} ", id);
		UUID uuid = UUIDConverter.stringToUUIDConverter(id);
		if (!taskRepository.findById(uuid).isPresent()) {
			logger.error("Task Not Found with the given UUID: {} ", id);
			throw new TaskNotFoundException("Task Not Found with the given UUID : " + id);
		}
		taskRepository.deleteById(uuid);
		logger.info("Task deleted successfully with ID: {} ", id);
	}

	@Override
	@Transactional
	@Modifying
	public TaskDTO markTaskAsCompleted(String id) {
		logger.info("Marking task with ID: {} as completed.", id);
		UUID uuid = UUIDConverter.stringToUUIDConverter(id);
		return taskRepository.findById(uuid).map(task -> {
			task.setStatus(Status.COMPLETED);
			Task updatedTask = taskRepository.save(task);
			logger.info("Task marked as completed with ID: {} ", updatedTask.getId());
			return convertToDTO(updatedTask);
		}).orElseThrow(() -> {
			logger.error("Task Not Found with the given UUID: {} ", id);
			return new TaskNotFoundException("Task Not Found with the given UUID: " + id);
		});
	}

	private Task convertToEntity(CreateTaskDTO taskDTO) {
		logger.debug("Converting CreateTaskRequestDTO to Task entity: {} ", taskDTO);
		Task task = new Task();
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		return task;
	}

	private TaskDTO convertToDTO(Task task) {
		logger.debug("Converting Task entity to TaskDTO: {} ", task);
		return new TaskDTO(task.getId().toString(), task.getTitle(), task.getDescription(),
				task.getDueDate().toString(), task.getStatus().toString());
	}

	private CreateTaskResponse convertToCreateTaskResponse(Task task) {
		logger.debug("Converting Task entity to CreateTaskResponse: {} ", task);
		return new CreateTaskResponse(task.getId().toString(), task.getTitle(), task.getDescription(),
				task.getDueDate().toString(), task.getStatus().toString());
	}

	private Task updateTaskFromDTO(Task existingTask, UpdateTaskDTO taskRequestDTO) {
		logger.debug("Updating existing Task with new details: {} ", taskRequestDTO);
		if (taskRequestDTO.getTitle() != null && !taskRequestDTO.getTitle().isBlank()) {
			existingTask.setTitle(taskRequestDTO.getTitle());
		}
		if (taskRequestDTO.getDescription() != null && !taskRequestDTO.getDescription().isBlank()) {
			existingTask.setDescription(taskRequestDTO.getDescription());
		}
		if (taskRequestDTO.getDueDate() != null) {
			existingTask.setDueDate(taskRequestDTO.getDueDate());
		}
		return existingTask;
	}

	private UpdateTaskResponse convertToUpdateTaskResponse(Task task) {
		logger.debug("Converting Task entity to UpdateTaskResponse: {} ", task);
		return new UpdateTaskResponse(task.getId().toString(), task.getTitle(), task.getDescription(),
				task.getStatus().toString(), task.getDueDate().toString());
	}
}