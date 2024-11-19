package com.example.taskmanagement.service.scheduler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taskmanagement.model.Status;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;

@Service
public class TaskStatusScheduler {
	
	private TaskRepository taskRepository;
	
	public TaskStatusScheduler(TaskRepository repository) {
		this.taskRepository=repository;
	}
	
	@Scheduled(fixedRate = 60000)
	@Transactional
	@Modifying
	public void updateTaskStatus() {
		List<Task> updatePendingTasksToInProgressStatus = 
				taskRepository.findByStatus(Status.PENDING);
		
		for (Task task : updatePendingTasksToInProgressStatus) {
			if (task.getCreatedAt().isBefore(LocalDateTime.now(ZoneId.systemDefault()).minusMinutes(5))) {
				task.setStatus(Status.IN_PROGRESS);
				taskRepository.save(task);
			}
		}
	}
}