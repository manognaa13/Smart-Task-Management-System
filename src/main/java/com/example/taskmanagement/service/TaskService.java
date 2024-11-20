package com.example.taskmanagement.service;

import java.util.List;
import java.util.Optional;

import com.example.taskmanagement.dto.CreateTaskRequestDTO;
import com.example.taskmanagement.dto.CreateTaskResponse;
import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.dto.UpdateTaskRequestDTO;
import com.example.taskmanagement.dto.UpdateTaskResponse;

public interface TaskService {
	
	abstract List<TaskDTO> getAllTasks();
	abstract Optional<TaskDTO> getTaskById(String id);
	abstract CreateTaskResponse createANewTask(CreateTaskRequestDTO newTaskDTO);
	abstract UpdateTaskResponse updateAnExistingTask(String id, UpdateTaskRequestDTO updatedTask);
	abstract void deleteAnExistingTask(String id);
	abstract TaskDTO markTaskAsCompleted(String id);
}