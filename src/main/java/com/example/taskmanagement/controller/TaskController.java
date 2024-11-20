package com.example.taskmanagement.controller;

import java.util.List;
import java.util.Map;

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

import com.example.taskmanagement.dto.CreateTaskRequestDTO;
import com.example.taskmanagement.dto.CreateTaskResponse;
import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.dto.UpdateTaskRequestDTO;
import com.example.taskmanagement.dto.UpdateTaskResponse;
import com.example.taskmanagement.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
	
	private TaskService taskService;
	
	public TaskController(TaskService service) {
		this.taskService=service;
	}
	
	@GetMapping
	public List<TaskDTO> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@GetMapping("/id")
	public ResponseEntity<TaskDTO> getTaskById(@RequestParam String id) {
		return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<CreateTaskResponse> createTask(@Valid @RequestBody CreateTaskRequestDTO taskRequestDTO) {
		CreateTaskResponse response = taskService.createANewTask(taskRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
	
	@DeleteMapping("/id")
    public ResponseEntity<Map<String, String>> deleteTask(@RequestParam String id) {
        taskService.deleteAnExistingTask(id);
        Map<String, String> response = Map.of(
                "Message", "Task has been Deleted Successfully.",
                "id", id
        );
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
	
	@PatchMapping("/id")
    public ResponseEntity<Map<String, Object>> markTaskAsComplete(@RequestParam String id) {
        	TaskDTO dto = taskService.markTaskAsCompleted(id);
            Map<String, Object> response = Map.of(
            		"Message", "Task has been Marked as Completed Successfully.",
                    "task", dto 
                    );
            return ResponseEntity.status(HttpStatus.OK).body(response);
    }
	
	@PutMapping("/id")
    public ResponseEntity<UpdateTaskResponse> updateTask(@RequestParam String id, @Valid @RequestBody UpdateTaskRequestDTO requestDTO) {
            return ResponseEntity.ok(taskService.updateAnExistingTask(id, requestDTO));
    }
}