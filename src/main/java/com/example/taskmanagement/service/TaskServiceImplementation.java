package com.example.taskmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taskmanagement.dto.CreateTaskRequestDTO;
import com.example.taskmanagement.dto.CreateTaskResponse;
import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.dto.UpdateTaskRequestDTO;
import com.example.taskmanagement.dto.UpdateTaskResponse;
import com.example.taskmanagement.exception.InvalidUUIDFormatException;
import com.example.taskmanagement.exception.TaskNotFoundException;
import com.example.taskmanagement.model.Status;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;

@Service(value = "TaskService")
public class TaskServiceImplementation implements TaskService {
	
	private TaskRepository taskRepository;
	
	public TaskServiceImplementation(TaskRepository repository) {
		this.taskRepository = repository;
	}

	@Override
	public List<TaskDTO> getAllTasks() {
		return taskRepository.findAll()
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<TaskDTO> getTaskById(String id) {
		UUID uuid = stringToUUIDConverter(id);
		if (!taskRepository.findById(uuid).isPresent()) {
			throw new TaskNotFoundException("Task Not Found with the given UUID : " + id);
		}
		return taskRepository.findById(uuid)
				.map(this::convertToDTO);
	}

	@Override
	@Transactional
	@Modifying
	public CreateTaskResponse createANewTask(CreateTaskRequestDTO taskRequestDTO) {
		LocalDate dueDate = (taskRequestDTO.getDueDate() != null)
				? taskRequestDTO.getDueDate()
				: LocalDate.now().plusDays(7);
		Task task = convertToEntity(taskRequestDTO);
		task.setDueDate(dueDate);
		Task savedTask = taskRepository.save(task);
		return convertToCreateTaskResponse(savedTask);
	}

	@Override
	@Transactional
	@Modifying
	public UpdateTaskResponse updateAnExistingTask(String id, UpdateTaskRequestDTO updatedTaskDTO) {
		UUID uuid = stringToUUIDConverter(id);
		return 
				taskRepository.findById(uuid).map(existingTask -> {
					updateTaskFromDTO(existingTask, updatedTaskDTO);
					Task updatedTask = taskRepository.save(existingTask);
					return convertToUpdateTaskResponse(updatedTask);
				}).orElseThrow(() -> new TaskNotFoundException("Task Not Found with the given UUID : " + id));
	}

	@Override
	@Transactional
	@Modifying
	public void deleteAnExistingTask(String id) {
		UUID uuid = stringToUUIDConverter(id);
		if (!taskRepository.findById(uuid).isPresent()) {
			throw new TaskNotFoundException("Task Not Found with the given UUID : " + id);
		}
		taskRepository.deleteById(uuid);
	}

	@Override
	@Transactional
	@Modifying
	public TaskDTO markTaskAsCompleted(String id) {
		UUID uuid = stringToUUIDConverter(id);
		return taskRepository.findById(uuid).map(task -> {
			task.setStatus(Status.COMPLETED);
			Task updatedTask = taskRepository.save(task);
			return convertToDTO(updatedTask);
		}).orElseThrow(() -> new TaskNotFoundException("Task Not Found with the given UUID : " + id));
	}
	
	private UUID stringToUUIDConverter(String id) {
			if (id == null || !id.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")) {
		        throw new InvalidUUIDFormatException("Invalid UUID Format: " + id);
		    }
			UUID uuid = UUID.fromString(id);
			return uuid;
	}
	
	private Task convertToEntity(CreateTaskRequestDTO taskDTO) {
		Task task = new Task();
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		return task;
	}
	
	private TaskDTO convertToDTO(Task task) {
		return new 
				TaskDTO(
						task.getId().toString(),
						task.getTitle(),
						task.getDescription(),
						task.getDueDate().toString(),
						task.getStatus().toString()
						);
	}
	
	private CreateTaskResponse convertToCreateTaskResponse(Task task) {
		return 
				new CreateTaskResponse(task.getId().toString(), 
						task.getTitle(), 
						task.getDescription(), 
						task.getDueDate().toString(), 
						task.getStatus().toString()
						);
	}
	
	private Task updateTaskFromDTO(Task existingTask, UpdateTaskRequestDTO taskRequestDTO) {
		if (taskRequestDTO.getTitle() != null && !taskRequestDTO.getTitle().isBlank()) {
			existingTask.setTitle(taskRequestDTO.getTitle());
		}
		if (taskRequestDTO.getDescription() != null && !taskRequestDTO.getDescription().isBlank()) {
			existingTask.setDescription(taskRequestDTO.getDescription());
		}
		if (taskRequestDTO.getDueDate() != null ) {
			existingTask.setDueDate(taskRequestDTO.getDueDate());
		}
		return existingTask; 
	}
	
	private UpdateTaskResponse convertToUpdateTaskResponse(Task task) {
		return new UpdateTaskResponse(
		        task.getId().toString(),
		        task.getTitle(),
		        task.getDescription(),
		        task.getStatus().toString(),
		        task.getDueDate().toString()
		    );
	}
}