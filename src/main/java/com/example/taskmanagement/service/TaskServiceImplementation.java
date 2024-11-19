package com.example.taskmanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.exception.TaskNotFoundException;
import com.example.taskmanagement.model.Status;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;

@Service(value = "TaskService")
public class TaskServiceImplementation implements TaskService{
	
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
	public TaskDTO createANewTask(TaskDTO taskDTO) {
		Task task = convertToEntity(taskDTO);
		Task savedTask = taskRepository.save(task);
		return convertToDTO(savedTask);
	}

	@Override
	@Transactional
	@Modifying
	public TaskDTO updateAnExistingTask(String id, TaskDTO updatedTaskDTO) {
		UUID uuid = stringToUUIDConverter(id);
		return 
				taskRepository.findById(uuid).map(existingTask -> {
					existingTask.setTitle(updatedTaskDTO.getTitle());
					existingTask.setDescription(updatedTaskDTO.getDescription());
					existingTask.setDueDate(updatedTaskDTO.getDueDate());
					Task updatedTask = taskRepository.save(existingTask);
					return convertToDTO(updatedTask);
				}).orElseThrow(() -> new TaskNotFoundException("Task Not Found with the given UUID : " + id));
	}

	@Override
	@Transactional
	@Modifying
	public void deleteAnExistingTask(String id) {
		UUID uuid = stringToUUIDConverter(id);
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
		UUID uuid = UUID.fromString(id);
		return uuid;
	}
	
	private Task convertToEntity(TaskDTO taskDTO) {
		Task task = new Task();
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		task.setDueDate(taskDTO.getDueDate());
		return task;
	}
	
	private TaskDTO convertToDTO(Task task) {
		return new 
				TaskDTO(
						task.getId(),
						task.getTitle(),
						task.getDescription(),
						task.getDueDate(),
						task.getStatus());
	}
}