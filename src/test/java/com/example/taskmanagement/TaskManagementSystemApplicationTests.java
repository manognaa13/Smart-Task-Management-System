package com.example.taskmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskManagementSystemApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void testCreateANewTask() {
//		CreateTaskDTO taskDTO = new CreateTaskDTO();
//		taskDTO.setTitle(faker.lorem().sentence(5));
//		taskDTO.setDescription(faker.lorem().paragraph(1));
//		taskDTO.setDueDate(LocalDate.now().plusDays(7));
//
//		UUID mockTaskID = UUID.randomUUID();
//		Status taskStatus = Status.PENDING;
//
//		CreateTaskResponse response = new CreateTaskResponse(mockTaskID.toString(), taskDTO.getTitle(),
//				taskDTO.getDescription(), taskDTO.getDueDate().toString(), taskStatus.toString());
//
//		when(taskService.createANewTask(any(CreateTaskDTO.class))).thenReturn(response);
//
//		ResponseEntity<CreateTaskResponse> result = taskController.createTask(taskDTO);
//
//		assertEquals(HttpStatus.CREATED, result.getStatusCode());
//		assertNotNull(result.getBody());
//		assertEquals(response.id(), result.getBody().id());
//		assertEquals(response.title(), result.getBody().title());
//		assertEquals(response.description(), result.getBody().description());
//		assertEquals(response.dueDate(), result.getBody().dueDate());
//		assertEquals(response.status(), result.getBody().status());
//		
//		verify(taskService, times(1)).createANewTask(any(CreateTaskDTO.class));
//	}
}