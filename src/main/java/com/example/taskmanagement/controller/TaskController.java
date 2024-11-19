package com.example.taskmanagement.controller;

import java.util.List;
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
import com.example.taskmanagement.service.TaskService;

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
                .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public TaskDTO createTask(@RequestBody TaskDTO task) {
        return taskService.createANewTask(task);
    }
	
	@DeleteMapping("/id")
    public ResponseEntity<Void> deleteTask(@RequestParam String id) {
        taskService.deleteAnExistingTask(id);
        return ResponseEntity.noContent().build();
    }
	
	@PatchMapping("/id")
    public ResponseEntity<TaskDTO> markTaskAsComplete(@RequestParam String id) {
        try {
            return ResponseEntity.ok(taskService.markTaskAsCompleted(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PutMapping("/id")
    public ResponseEntity<TaskDTO> updateTask(@RequestParam String id, @RequestBody TaskDTO task) {
        try {
            return ResponseEntity.ok(taskService.updateAnExistingTask(id, task));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}