package com.example.taskmanagement.service.scheduler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taskmanagement.enums.Status;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @Service for scheduling and updating the status of tasks.
 * 
 *          This service periodically checks for tasks that are in the PENDING
 *          status and updates their status to IN_PROGRESS if they have been
 *          pending for more than 5 minutes.
 */
@Service
@Slf4j
public class TaskStatusScheduler {

	private static final Logger logger = LoggerFactory.getLogger(TaskStatusScheduler.class);

	private TaskRepository taskRepository;

	/**
	 * @Constructor for @TaskStatusScheduler
	 * 
	 * @param repository the @TaskRepository to be used for task operations
	 */
	public TaskStatusScheduler(TaskRepository repository) {
		this.taskRepository = repository;
	}

	/**
	 * @Scheduled method that runs every 60 seconds to update task statuses.
	 * 
	 *            This method retrieves all tasks with a PENDING status and checks
	 *            if they have been created for more than 5 minutes. If so, their
	 *            status is updated to IN_PROGRESS.
	 */
	@Scheduled(fixedRate = 60000)
	@Transactional
	@Modifying
	public void updateTaskStatus() {
		logger.info("Checking for tasks to update status...");
		List<Task> updatePendingTasksToInProgressStatus = taskRepository.findByStatus(Status.PENDING);
		logger.info("Found {} pending tasks. ", updatePendingTasksToInProgressStatus.size());

		for (Task task : updatePendingTasksToInProgressStatus) {
			if (task.getCreatedAt().isBefore(LocalDateTime.now(ZoneId.systemDefault()).minusMinutes(5))) {
				logger.info("Updating task ID {} from PENDING to IN_PROGRESS. ", task.getId());
				task.setStatus(Status.IN_PROGRESS);
				taskRepository.save(task);
			}
		}
		logger.info("Task status update process completed.");
	}
}