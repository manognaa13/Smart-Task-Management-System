package com.example.taskmanagement.service;

import java.util.List;
import java.util.Optional;

import com.example.taskmanagement.dto.TaskDTO;

public interface TaskService {
	
	abstract List<TaskDTO> getAllTasks();
	abstract Optional<TaskDTO> getTaskById(String id);
	abstract TaskDTO createANewTask(TaskDTO newTaskDTO);
	abstract TaskDTO updateAnExistingTask(String id, TaskDTO updatedTask);
	abstract void deleteAnExistingTask(String id);
	abstract TaskDTO markTaskAsCompleted(String id);
}