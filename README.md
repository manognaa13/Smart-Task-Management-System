# Smart Task Management System

A **RESTful API** for managing tasks, built with **Spring Boot** and **MySQL**, using **UUIDs** as primary keys. The system enables intelligent task handling with automated status updates, CRUD operations, and strong support for DSA, OOP, and database design.

### Features

- **CRUD Operations:** Create, read, update, and delete tasks effortlessly.  
- **Task Status Management:** Tasks automatically transition from **PENDING → IN_PROGRESS → COMPLETED** using an asynchronous scheduler.  
- **UUID Support:** Each task is identified using a **unique UUID** for scalability.  
- **Input Validation & Error Handling:** Robust validation using `@Valid` and centralized exception handling with `@RestControllerAdvice`.  
- **Extensible Architecture:** Clear separation of concerns with **Controller, Service, Repository layers**.  
- **Logging:** Comprehensive logging (INFO, DEBUG, ERROR) for monitoring and debugging.  
- **DTO Pattern:** Decouples internal models from API responses for maintainability.

### Tech Stack

- **Backend:** Java 17+, Spring Boot, Spring Data JPA  
- **Database:** MySQL  
- **Build Tool:** Apache Maven  
- **Testing Tools:** JUnit, Mockito  
- **API Testing:** Postman or HTTPie

### How It Works

- Users can **create tasks** with a title, description, and optional due date.  
- Tasks automatically update their status after **5 minutes** using a scheduler.  
- **Validation** ensures invalid inputs and incorrect UUIDs are handled gracefully.  
- Designed to **scale** with clean, modular code and maintainable architecture.

---

### Future Enhancements

- **Spring Security & JWT:** Secure endpoints with role-based access.  
- **Task Prioritization:** Introduce **HIGH, MEDIUM, LOW** priority levels.  
- **Frontend Application:** Build a dynamic Angular interface.  
- **Pagination, Sorting & Filtering:** Enhance usability for large task sets.  
- **Advanced Scheduler:** Use Quartz or enhanced Spring Scheduler for custom workflows.  
- **Swagger/OpenAPI Documentation:** Interactive API docs for developers.  
- **HATEOAS Integration:** Dynamic, self-descriptive API responses with HAL Explorer.  
- **Monitoring & Logging:** Integrate Prometheus, Grafana, and SLF4J/Logback logging.  
- **Notification System:** Email, SMS, or push notifications for task updates.  
- **Gamification:** Streaks and points for completing high-priority tasks.  
- **Docker Support:** Containerized deployment for consistent environments.


### Prerequisites

- Java 17+  
- Apache Maven  
- MySQL (running instance)  
- IDE: IntelliJ, Eclipse, VSCode, or Spring Tools Suite  
- API testing tools: Postman
