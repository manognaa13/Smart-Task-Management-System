### **💫 `About Me`** <img src="https://media.giphy.com/media/pDh3IDoUswmZrqdRip/giphy.gif" height="27px" width="25px">

<h3 align="center">👨🏼‍💻 A Passionate Java Backend Developer</h3>

<img align="right" alt="Coder GIF" width="300px" style="border-radius: 15px 50px;" src="https://images.squarespace-cdn.com/content/v1/5769fc401b631bab1addb2ab/1541580611624-TE64QGKRJG8SWAIUS7NS/ke17ZwdGBToddI8pDm48kPoswlzjSVMM-SxOp7CV59BZw-zPPgdn4jUwVcJE1ZvWQUxwkmyExglNqGp0IvTJZamWLI2zvYWH8K3-s_4yszcp2ryTI0HqTOaaUohrI8PI6FXy8c9PWtBlqAVlUS5izpdcIXDZqDYvprRqZ29Pw0o/coding-freak.gif"/>

- I am **Manoj Kumar Reddy** from **Vijayawada**, **Andhra Pradesh**, **India**.
- A **Java Backend Developer** with a strong foundation in **Java** and **Spring Boot**.
- I'm driven by **creating impactful solutions** that improve **user experiences** and solve **real-world problems**.

### **🌱 `My Goals`**

- To **`Continue Learning`** and **`Growing`** in the field of **`Software Development`**.

- To **`Contribute`** to **`Projects`** that make a **`Positive Impact`**.

<br>
<hr>

### 💻 **`My Skills & Expertise`** <img src='https://user-images.githubusercontent.com/74038190/206662607-d9e7591e-bbf9-42f9-9386-29efc927bc16.gif' width="30">

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=aws,docker,github,git,vscode,eclipse,javascript"/>
  </a>
</p>

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,maven,spring,hibernate,rabbitmq,kafka,typescript"/>
  </a>
</p>

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=postman,postgres,mysql,md,html,css,mongodb,bootstrap,angular,idea,prometheus"/>
  </a>
</p>

<hr>

### 🌐 **`Connect with Me`**

<div align="center">

[![LinkedIn](https://img.shields.io/badge/LinkedIn-%230077B5.svg?logo=linkedin&style=social&logoColor=blue)](https://linkedin.com/in/bhimavarapu-manoj-kumar-reddy) [![GitHub](https://img.shields.io/badge/GitHub-100000?style=social&logo=github&logoColor=brown)](https://github.com/BHIMAVARAPU-MANOJ-KUMAR) [![Instagram](https://img.shields.io/badge/Instagram-E4405F?style=social&logo=instagram&logoColor=darkpink)](https://www.instagram.com/manoj.kumar.reddy.bhimavarapu/) [![WhatsApp](https://img.shields.io/badge/WhatsApp-25D366?style=social&logo=whatsapp&logoColor=darkgreen)](https://web.whatsapp.com/send?phone=919010917345&text=Hello%2C%20I%20found%20you%20on%20GitHub.%0AI%27m%20impressed!)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=social&logo=gmail&logoColor=red&link=mailto:manojbh1999@gmail.com)](mailto:manojbh1999@gmail.com)

</div>

<hr>

### **`Project Case Study - Wellness360`**

<div align="center">

### **`Task Management System`**

### **![Static Badge](https://img.shields.io/badge/Task%20Management%20System%20-%20Spring%20Boot-CAF2EF)**

A **`RESTful API`** for managing tasks, built using **`Spring Boot`** and **`MySQL`** with **`UUID`** as the primary key for tasks.

The system allows users to **`Create`**, **`Read`**, **`Update`**, **`Delete`** Tasks, and automatically update their status from **`PENDING`** to **`IN_PROGRESS`** after a specified time using an **`Asynchronous Scheduler`**.

</div>

<hr>

### **`Features`**

1. **`CRUD Operations :- `**

   - **`Create`**, **`Retrieve`**, **`Update`**, and **`Delete`** Tasks.
   - Status find transitions - **`PENDING`**, **`IN_PROGRESS`**, **`COMPLETED`**

2. **`UUID Support :- `**

   - Tasks are Identified using **`Unique`** **`UUIDs`** for **`Scalability`**.

3. **`Asynchronous Scheduler :- `**

   - Automatically updates the Task Status to **`IN_PROGRESS`** after **`5 minutes`** from the **`Task Creation DateTime Stamp`**.

4. **`Input Validation and Error Handling :- `**

   - Gracefully Handling of Invalid User Input using **`@Valid`** Annotation, including **`UUID`** formats when retrieving.
   - Implemented **`Centralized Exception Handling`** in the Application using concepts **`@RestControllerAdvice`**, **`@ExceptionHandler`** Annotations.

5. **`Extensible Design :- `**

   - Entity-Based design with clear seperation of concers between **`Service`**, **`Repository`**, & **`Controller`** **`Layers`**.

6. **`Logging :- `**

   - Logging is an essential feature for **`Monitoring`** and **`Debugging`** the application.
   - It helps in tracking the flow of the application, recording **`Significant Events`**, and **`Diagnosing`** **`Issues`**.
   - In this project, I've Implemented a Comprehensive Logging mechanism (**`INFO`**, **`DEBUG`**, **`ERROR`**) to capture various **`Aspects of the Application's Behavior`**.

7. **`DTO Pattern Concept :- `**

   - Employed the **`Data Transfer Object (DTO)`** pattern to decouple the internal data model.
   - This ensures the flexibility to refactor entity classes without impacting external clients.

- **`Basic DTO Image as Follows :-`**
- ![Basic DTO Image](https://github.com/BHIMAVARAPU-MANOJ-KUMAR/Task-Management-System-Using-Spring-Boot/blob/main/images/dtoimage.jpg?raw=true)

- **`DTO Sequence Diagram as Follows (Manual-Mapping):-`**
- ![DTO Sequence Diagram](https://github.com/BHIMAVARAPU-MANOJ-KUMAR/Task-Management-System-Using-Spring-Boot/blob/main/images/dtosequencediagram.webp?raw=true)

- **`Mapping Frameworks DTO Sequence Diagram as Follows :-`**
- ![Mapping Frameworks DTO Sequence Diagram](https://github.com/BHIMAVARAPU-MANOJ-KUMAR/Task-Management-System-Using-Spring-Boot/blob/main/images/dto2.webp?raw=true)
  - **`Model Mapper - Java Bean Mapping`**
  - **`Map Struct - Object Mapping`**
  - **`Dozer`**
  - **`These are the Mapping frameworks available`**
  - **[For more check the Medium.com Technical Blog on this Concept](https://blog.stackademic.com/efficient-data-transfer-in-rest-apis-a-deep-dive-into-the-dto-pattern-with-spring-boot-and-mysql-df2bdf1ece74)**
  - **[Understanding of DTOs, Article from - Delta Dev Software](https://delta-dev-software.fr/understanding-data-transfer-objects-dto-in-spring-boot-a-comprehensive-guide)**

8. **`Interceptors Concept :- `**

   - A **`Request Interceptor`** in Spring Boot is a component that intercepts incoming HTTP requests before they are processed by the controller.
   - It allows you to perform **`Pre-Processing Tasks`**, such as **`Logging`**, **`Authentication`**, **`Validation`**, or Modifying the request/response, before passing it to the controller.

- **`Example Use Cases :-`**
  - **Logging Incoming Requests**
  - **Authentication and Authorization**
  - **Adding Custom Headers**
  - **Request/Response Modification**
  - **[Basic Understanding of Interceptors, Article from - Delta Dev Software](https://delta-dev-software.fr/getting-started-with-spring-boot-request-interceptor-a-step-by-step-tutorial)**

9. **`Project Lombok :- `**

   - Project **`Lombok`** is a **`Java Library`** that reduces boilerplate code, making code easier to read, maintain, and less error-prone.
   - **`Lombok`** uses **`Annotations`** to replace **`Repetitive`**, **`Tedious`**, or **`Boilerplate`** Java code.
   - For example, you can avoid writing **`Constructors`** with no arguments, **`toString()`**, **`equals()`**, and **`hashCode()`** methods by adding a few **`Annotations`**.

<br>

# **`Setup & Running the Project`**

### **`Prerequisites`**

- **Ensure you have the following installed on your Local Development System :-**

1. **`Java 17 or Later`**
2. **`Apache Maven`**
3. **`MySQL Latest Release`(Ensure the Database is Successfully Installed, Up & Running)**
4. **`IDE - Integrated Development Environment Tools Like IntelliJ IDEA, Eclipse, VSCode or STS - Spring Tools Suit`(Ensure anyone of the above IDEs are Installed)**
5. **`Postman or HTTPie Client Tool for Sending HTTP Requests to the backend server`**

### **`Tech Stack & Database Choice`**

- **`Spring Boot :- `** Chosen for it's comprehensive support for building **`Production-Ready`** Application with the best Features and ease of Integrating with other Spring Components.
- **`Spring Data JPA :- `** Facilitates the data access layer and abstracts much of the boilerplate code.
- **`Apache Maven Project/Dependency Management Tool :- `**

  - **Maven** is a popular **Open-Source** build tool developed by the **Apache Group**.
  - The tool provides allows developers to **build** and document the **lifecycle framework**.
  - It is primarily used to simplify the **Java development** process by automating the **build** process, **managing project dependencies** (**`like downloading necessary libraries`**), and providing a **standardized way** to **build**, **test**, and **package applications**, essentially making it easier for developers to manage complex project structures and dependencies without manually handling each library download and configuration.

- **`MySQL Database :- `** Chosen for it's **`Robustness`**, **`Performance`** and support for **`Advanced`** data types.

<br>

<p align="center">
  <a href="https://skillicons.dev">
  <img src="https://skillicons.dev/icons?i=java,eclipse,hibernate,maven,md,mysql&theme=light"/>
  </a>
</p>

<p align="center">
<a href="https://skillicons.dev">
<img src="https://skillicons.dev/icons?i=idea,vscode,docker,aws,spring,postman">
</p>

<hr>

### **`Design Decisions`**

1. **`Extensible Design : `**

   - Entity-Based design with clear seperation of concers between **`Service`**, **`Repository`**, & **`Controller`** **`Layers`**.

2. **`Followed a Package by Layer Approach :- `**

- This approach **`organizes Software Components`** based on their **`Architectural Layers`**. Each layer has a **`Specific Responsibility`**, and this separation helps manage **`Complexity`**. Common layers in software architecture include :-
  - **Presentation Layer**
  - **Business Logic Layer**
  - **Data Access Layer**
  - **Infrastructure Layer**

![Package by Layer](https://github.com/BHIMAVARAPU-MANOJ-KUMAR/Task-Management-System-Using-Spring-Boot/blob/main/images/package_by_layer.png?raw=true)

- **[Medium.com Technical Blog on Architectural Layers](https://medium.com/sahibinden-technology/package-by-layer-vs-package-by-feature-7e89cde2ae3a)**

- **[Structuring Packages in Java](https://blog.indrek.io/articles/structuring-packages-in-java-web-applications/)**

3. **`Package by Feature :- `**
   - This approach **`Organizes Software Components`** based on **`Specific Features or Functionalities`** of the application.
   - Each package contains everything related to a particular Feature, making it easier to manage and develop.

![Package by Feature](https://github.com/BHIMAVARAPU-MANOJ-KUMAR/Task-Management-System-Using-Spring-Boot/blob/main/images/package_by_feature.png?raw=true)

- **For Example :-**

  - **`User Management Package`**
  - **`Product Management Package`**
  - **`Order Processing Package`**

- **`Conclusion :- `**

  - **`Choosing between these two approaches depends on the project requirements, team structure, and maintenance considerations. Some projects may even use a combination of both methods for optimal organization.`**

4. **`Field-Level Security with @JsonIgnore`**

   - Applied @JsonIgnore on sensitive or internal fields (e.g., createdAt, updatedAt) in the DTO to prevent them from being exposed in the API response, ensuring better API security.

5. **`Enum for Task Status`**

   - Defined task statuses (pending, in_progress, completed)
     as an Enum to enforce type safety and restrict possible values. This simplifies the management of task lifecycles.

6. **`Validation Annotations`**

   - Used @NotBlank, @NotNull, and other annotations to enforce validation rules at the model level, ensuring data consistency and reducing the risk of invalid inputs being processed.
   - Enforced @Size, @Min, @Max and @Future validation Annotations.

7. **`Database Configuration Strategy`**

   - Poduction Database :- MySQL
   - Development Database :- H2 In-Memory with file Storage persistence

8. **`Use of Profiles in Application Configuration`**

   - In this application, I utilized different profiles to manage environment-specific configurations effectively.
   - This approach allows us to tailor settings for production and development environments, ensuring optimal performance, security, and ease of development.

<br>
<hr>

### **`Future Improvements & Enhancements`**

1. **`Securing Endpoints with Spring Security`**

   - We will implement Spring Security to protect our RESTful endpoints. This will ensure that only authenticated and authorized users can access specific functionalities of the application.
   - By integrating Spring Security, we can secure our endpoints, manage user roles, and protect sensitive data.
   - Total solution for User Management and Auditing.
   - **`JWT Authentication :- For stateless authentication, consider implementing JWT (JSON Web Tokens) for a more secure and scalable solution.`**
   - **`Role-Based Access Control :- Enhance security by defining roles and permissions for different user types.`**

2. **`Task Priority`**

   - Introduce a priority field for each task to allow users to categorize tasks based on importance (e.g., **`HIGH`**, **`MEDIUM`**, **`LOW`**).
   - Update the database schema to include a priority column and modify the task model accordingly.

3. **`Extensive Test Cases`**

   - Implement comprehensive test cases for both the Controller and Service layers using JUnit and Mockito.
   - Ensure that all critical functionalities are covered, including edge cases and error handling, to maintain code quality and reliability.

4. **`Planning of Implementing a Frontend Application using Angular`**

   - Develop a frontend application using Angular to provide a dynamic and user-friendly interface for TaskMaster.
   - The frontend will interact with the backend API to manage tasks, display task lists, and allow users to create, update, and delete tasks seamlessly.

5. **`Pagination, Sorting and Filtering of Data Dynamically`**

   - Implement pagination to allow users to navigate through large sets of tasks easily, enhancing usability and performance.
   - Introduce sorting options to enable users to organize tasks based on different criteria such as due date, priority, or status.
   - Enable dynamic filtering capabilities, allowing users to search for tasks based on specific attributes (e.g., keyword search, priority level, or due date).
   - Ensure that the frontend and backend are seamlessly integrated to support these features, providing a smooth user experience.

6. **`Scheduler Enhancements`**

   - Integrate Quartz Scheduler or Spring Scheduler to manage complex workflows and job persistence within the application.
   - Implement automated task status updates: when a user marks a task's priority as high, the system will automatically change the task status from Pending to In Progress.
   - This enhancement will streamline task management, ensuring that high-priority tasks are promptly addressed without manual intervention.
   - Enable configuration options for users to define custom workflows and scheduling parameters for different task types.

7. **`Spring Doc Swagger UI, Swagger API OpenAPI's Specification`**

   - Swagger UI provides an interactive interface for users to visualize and interact with the API endpoints. This enhances developer experience by allowing them to easily test and understand the available API functionalities without needing to write additional code.
   - OpenAPI Specification (formerly known as Swagger Specification) defines a standard, language-agnostic interface to RESTful APIs. It allows both humans and computers to understand the capabilities of a service without direct access to the source code. By documenting the API endpoints, request/response formats, and authentication methods, it promotes better collaboration and integration with other services.

- Together, these tools facilitate :-
  - Easier onboarding for new developers and stakeholders by providing clear documentation.
  - Enhanced testing capabilities during development and debugging.
  - Improved maintainability and adaptability of the API as it evolves over time.

8. **`HATEOAS Integration and HAL Explorer`**

   - Integrating HATEOAS (Hypermedia as the Engine of Application State) with HAL (Hypertext Application Language) will enhance the API's usability and discoverability by allowing clients to navigate the application through hypermedia links.
   - This integration will provide a more intuitive interaction model, making it easier for developers to understand and utilize the API.
   - Expand the integration to cover all major resources within the application.
   - Improve HAL Explorer's capabilities to support more complex interactions and visualizations.
   - Provide comprehensive documentation and examples for developers to leverage HATEOAS effectively.

**`Example HAL Representation`**

```sh
A typical HAL response will look as follows

{
  "_links": {
    "self": {
      "href": "http://localhost:8080/orders/1"
         },
      "payments": {
         "href": "/payments/1"
         }
  },
  "orderId": "1",
  "state": "AWAITING_PAYMENT"
}

```

- Benefits :-
  - Dynamic Navigation :- Clients can discover available actions on resources through hypermedia links, reducing the need for hardcoded URLs.
  - Self-Descriptive API :- HAL provides a standard format for representing resources and their relationships, making the API more understandable.
  - Improved Usability :- Developers can leverage HAL Explorer to visualize API endpoints and navigate through resources interactively.

9. **`Monitoring`**

   - **`Production Logging`** :- Consider integrating monitoring tools (e.g., Prometheus, Grafana) to monitor database performance and health.

10. **`Spring Boot Starter Actuator`**

    - To Implement **`Spring Boot Actuator`**, it adds several **`Production Grade`** service to the Application. It mainly exposes operational information about the running application like health, metrics, info, dump, env, etc.

11. **`Model Mapper, MapStruct or Dozer`**

    - Implement Object mapping Frameworks with atleast Mapping tool.
    - To simplify the process of converting between different object types, we will implement an object mapping framework.
    - This will enable efficient and flexible data transformation between entities, DTOs, and other objects.

12. **`Stored Procedure in MySQL`**

    - To improve database performance and encapsulate complex logic, we will utilize stored procedures in MySQL.
    - Stored procedures allow us to define a set of SQL statements that can be executed as a single unit, reducing the overhead of multiple queries.
    - Can use this for Security purposes also.

13. **`Docker Image for the Application`**

    - To simplify the deployment process and ensure a consistent environment, we will create a Docker image for the application.
    - This will enable users to run the application in a containerized environment, reducing the risk of compatibility issues and making it easier to deploy the application.

14. **`Logging Configuration with SLF4J and Logback`**

    - To enhance logging capabilities in our application, we will utilize SLF4J as the logging facade and Logback as the logging implementation.
    - This configuration will allow us to maintain separate log files for production and development environments, facilitating easier debugging and monitoring.
    - As of now there are no seperate logs folders for the production and development environment. Implement it in future.

15. **`Streak and Points System for High-Priority Tasks`**

    - **`Major Feature for the Application`**
    - To encourage users to complete high-priority tasks, we will implement a streak and points system.
    - Users will earn points and maintain a streak when they complete a minimum of three high-priority tasks each day.
    - This system will motivate users to stay productive and engaged with their tasks.

16. **`Email Notification Service`**

    - In the future, I plan to implement an Email Notification Service to enhance user experience by notifying users when a new task is created and when a task is marked as complete.
    - This feature will utilize either Google SMTP or Amazon Simple Email Service (SES) for sending emails.

      - **`Future Considerations`**
        - Explore Multiple Notification channels like SMS, Push Notification(Web Sockets)

<br>
<hr>

### **`Package Structure`**

Here's how the package structure might look

```sh

Task Management System

com.example.taskmanagement

|--
|-- controller
|   |-- TaskController.java
|
|-- service
|   |-- taskservice
|       |-- TaskService.java
|   |-- impltaskservice
|       |-- ITaskService.java
|   |-- utilities
|       |-- UUIDConverter.java
|
|-- repository
|   |-- TaskRepository.java
|
|-- model
|   |-- Task.java
|
|-- dto
|   |-- TaskDTO.java
|   |-- createtask
|       |-- CreateTaskDTO.java
|       |-- CreateTaskResponse.java
|   |-- updatetask
|       |-- UpdateTaskDTO.java
|       |-- UpdateTaskResponse.java
|
|-- enums
|   |-- Status.java
|
|-- apiresponse
|   |-- ErrorResponse.java
|
|-- applicationconfiguration
|   |-- WebConfiguration.java
|
|-- exceptionhandler
|   |-- customexception
|       |-- InvalidUUIDFormatException.java
|       |-- TaskNotFoundException.java
|   |-- globalexceptionhandler
|       |-- GlobalExceptionHandler.java
|
|-- customvalidationannotation
|   |-- AtLeastOneFieldNotNull.java
|   |-- AtLeastOneFieldValidator.java
|
|-- requestinterceptor
|   |-- RequestInterceptor.java
|
|-- scheduler
|   |-- TaskStatusScheduler.java
|
|-- schedulerconfiguration
|   |-- SchedulerConfig.java
|
|-- mainapplication
|   |-- TaskManagementSystemApplication.java
|--

End
```

### **`Running the Project`**

1. **`Clone the Repository to your Local System`**

```sh
git clone https://github.com/BHIMAVARAPU-MANOJ-KUMAR/Task-Management-System-Using-Spring-Boot.git
```

```sh
windows command shell
cd Task-Management-System-Using-Spring-Boot
code .
```

2. **`Configure MySQL for Production Database`**

- **In the application.properties file configure the MySQL Properties as shown below**
- **By default the Spring Boot TomCat Server Port Number is 8080. I'm using 8090**

```sh

spring.datasource.url=jdbc:mysql://localhost:3306/task_management_system_db_name?createDatabaseIfNotExist=true

server.port=8090
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
```

- For more go to **`application.properties`** in the project [here](https://github.com/BHIMAVARAPU-MANOJ-KUMAR/Task-Management-System-Using-Spring-Boot/blob/main/src/main/resources/application.properties)

3. **`Configure H2 In-Memory Database for Local Development Database`**

- **In the application-dev.properties file configure the H2 Properties as shown below**
- **For the Development Environment use a different Port Number. I'm using 8080**

```sh

server.port=8080
spring.jpa.hibernate.ddl-auto=update

spring.sql.init.platform=h2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.datasource.url=jdbc:h2:file:./h2db-persistence-embedded-mode/devdbtaskmanagement

spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=your_custom_username
spring.datasource.password=your_custom_password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

- For more go to **`application-dev.properties`** in the project [here](https://github.com/BHIMAVARAPU-MANOJ-KUMAR/Task-Management-System-Using-Spring-Boot/blob/main/src/main/resources/application-dev.properties)

4. **`Build the Project`**

- **Maven Command to Build Project**

```sh
mvn clean install
```

5. **`Package the Application`**

- **Maven Command to Package**

```sh
mvn clean package
```

6. **`Run the Application`**

- **Maven Command to Run the Application**

```sh
mvn spring-boot:run
```

7. **`Access the Application`**

```sh
`http://localhost:8090/v1/tasks/**`
```

8. **`Run the Application on Development Environment`**

```sh
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
```

- **Access H2 Database - `http://localhost:8080/h2-console`**

9. **`Run the Application on Production Environment`**

```sh
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=prod"
```

10. **`Testing the Application`**

- **Run Unit Tests**

```sh
mvn test
```

### **`RESTful APIs Endpoints`**

- **Task Management System APIs**

| `HTTP Method` |        `API Endpoint`         |            `Description`            |
| :-----------: | :---------------------------: | :---------------------------------: |
|    **GET**    |        **`/v1/tasks`**        |         Retrieve all tasks          |
|    **GET**    |     **`/v1/tasks/{id}`**      |     Retrieve a task by its UUID     |
|   **POST**    |        **`/v1/tasks`**        |          Create a new Task          |
|    **PUT**    |     **`/v1/tasks/{id}`**      | Update an existing Task by its UUID |
|  **DELETE**   |     **`/v1/tasks/{id}`**      | Delete an existing Task by its UUID |
|   **PATCH**   | **`/v1/tasks/{id}/complete`** |       Mark a task as complete       |

- **Test the APIs (These are just an Example representation)**

  - **`GET - Retrieve all tasks`**

  ```sh
  curl -X GET http://localhost:8090/v1/tasks
  ```

  ```sh
  Response
  [
      {
         "id": "a6adfa05-d1fa-470a-b99c-b703ba39b19a",
         "title": "Wellness360 Software Engineering Intern.",
         "description": "Wellness360 Software Engineer Intern Last and Final Task EC2 Instance completed.",
         "dueDate": "2024-12-05",
         "status": "PENDING"
      }
  ]
  ```

  - **`GET - Retrieve a Task by its UUID`**

  ```sh
  curl -X GET http://localhost:8090/v1/tasks/a6adfa05-d1fa-470a-b99c-b703ba39b19a
  ```

  ```sh
  Response
  {
      "id": "a6adfa05-d1fa-470a-b99c-b703ba39b19a",
      "title": "Wellness360 Software Engineering Intern.",
      "description": "Wellness360 Software Engineer Intern Last and Final Task EC2 Instance completed.",
      "dueDate": "2024-12-05",
      "status": "PENDING"
  }
  ```

  - **`POST - Create a New Task`**

  ```sh
  curl -X POST http://localhost:8090/v1/tasks -H "Content-Type: application/json" -d '{"title": "New Task. New Task Title.", "description": "Description of the new task. Description of the new Task.", "dueDate": "2024-12-31"}'
  ```

  ```sh
  Response
  {
      "id": "18e51f3b-f256-4e93-aa4f-731e12705451",
      "title": "New Task. New Task Title.",
      "description": "Description of the new task. Description of the new Task.",
      "dueDate": "2024-12-31",
      "status": "PENDING"
  }
  ```

  - **`DELETE - Delete an existing task by its UUID`**

  ```sh
  curl -X DELETE http://localhost:8090/v1/tasks/18e51f3b-f256-4e93-aa4f-731e12705451
  ```

  ```sh
  Response

  204 No Content. It's actually Success message. If you try to retrieve the task with the deleted UUID it gives us 404 Not Found.

  {
      "httpStatus": "NOT_FOUND",
      "httpStatusCode": 404,
      "errorMessage": "Task Not Found with the given UUID : 18e51f3b-f256-4e93-aa4f-731e12705451",
      "timeStamp": "2024-11-29 10:25:43"
  }
  ```

  - **`PATCH - Mark an existing Task as Completed Status`**

  ```sh
  curl -X PATCH http://localhost:8090/v1/tasks/4f652b56-8410-46a4-a9b4-d7de9a96e09c/complete
  ```

  ```sh
  Response
  {
      "Message": "Task has been Marked as Completed Successfully.",
      "task": {
            "id": "4f652b56-8410-46a4-a9b4-d7de9a96e09c",
            "title": "New Task. New Task Title.",
            "description": "Description of the new task. Description of the new Task.",
            "dueDate": "2024-12-31",
            "status": "COMPLETED"
  }
  }
  ```

  - **`PUT - Update an existing Task by its UUID`**

  ```sh
  curl -X PUT http://localhost:8090/v1/tasks/4f652b56-8410-46a4-a9b4-d7de9a96e09c \
  -H "Content-Type: application/json" \
  -d '{
  "title": "Updated Task Title",
  "description": "Updated description of the task",
  "dueDate": "2024-12-09"
  }'
  ```

  ```sh
  Response
  {
      "id": "4f652b56-8410-46a4-a9b4-d7de9a96e09c",
      "title": "Updated Task Title",
      "description": "Updated description of the task",
      "status": "COMPLETED",
      "dueDate": "2024-12-09"
  }
  ```

<br>
<hr>

# **`Application Deployment Documentation`**

## **Table of Contents**

1. **`Prerequisites`**
2. **`Creating an RDS MySQL Instance`**
3. **`Creating an EC2 Instance`**
4. **`Configuring Security Groups`**
5. **`Connecting to EC2 Instance`**
6. **`Installing Java JDK`**
7. **`Transferring Files to EC2`**
8. **`Configuring Application Properties`**
9. **`Running the Application`**
10. **`API Endpoints`**
11. **`Conclusion`**

## **`Prerequisites`**

- **An AWS Account Free tier.**
- **Basic knowledge of AWS services (EC2, RDS).**
- **Local system with PuTTY and WinSCP installed.**

## **`Creating an RDS MySQL Instance`**

- **Log in to the AWS Management Console.**
- **Navigate to the RDS service.**
- **Click on "Create database."**
- **Select "Standard Create."**
- **Choose "MySQL" as the database engine.**
- **Select the version you want to use.**
- **Configure the DB instance settings :-**
  - **DB Instance Identifier :** **`your-db-instance-name`**
  - **Master username :** **`your-username`**
  - **Master password :** **`your-password`**
  - **DB Instance Class:** **`Choose an appropriate instance class (e.g., db.t2.micro for free tier).`**
- **Configure the settings for DB instance size, storage, etc. Select Free Tier**
- **Click "Create database" and wait for the instance to be available.**
- **Note the RDS endpoint URL, which will be used in the application configuration.**

## **`Creating an EC2 Instance`**

- **Navigate to the EC2 service in the AWS Management Console.**
- **Click on "Launch Instance."**
- **Choose an Amazon Machine Image (AMI), e.g., Amazon Linux 2.**
- **Select an instance type (e.g., t2.micro for free tier).**
- **Configure the instance details as needed.**
- **Add storage if necessary.(default is usually sufficient)**
- **Configure security group :**
  - **Create a new security group or select an existing one.**
  - **Allow inbound traffic on port 8090 (custom port for your application).**
  - **Allow inbound traffic on port 3306 for MySQL (for RDS access).**
- **Review and launch the instance.**
- **Create a new key pair, download the `.pem` file, and save it securely.**

## **`Configuring Security Groups`**

- **Navigate to "Security Groups" in the EC2 dashboard.**
- **Select the security group associated with your EC2 instance.**
- **Click on "Inbound rules."**
- **Click on "Edit inbound rules."**
- **Add a rule for custom TCP `(port 8090)` and set the source to "`Anywhere or IPv4`" `(0.0.0.0/0)`.**
- **Ensure that the RDS instance's security group allows inbound traffic from the EC2 instance.**

## **`Connecting to EC2 Instance`**

- **Convert the `.pem` key to `.ppk` format using `PuTTYgen.`**
- **Open PuTTY and enter the `public IPv4 DNS` of your `EC2` instance on the Host Name or IP Address on PuTTY.**
- **Under `"Connection" > "SSH" > "Auth" > "Credentials"`, browse for your .ppk file.**
- **Click "Open" to connect to the instance.**
- **Log in as `ec2-user` (or the appropriate user for your `AMI`).**

## **`Installing Java JDK`**

- **Install Amazon Corretto (Java JDK) 17 or Higher**

```sh
sudo dnf install java-17-amazon-corretto
```

- **Verify the Installation**

```sh
java -version
```

## **`Transferring Files to EC2`**

- **Open `WinSCP` and enter the public `IPv4 DNS of your EC2 instance`.**
- **Select `"SCP"` as the file protocol.**
- **Use `ec2-user` as the username and specify the path or select from the directory, your .ppk file for authentication.**
- **Connect to the instance and transfer your `.jar` file to a desired directory (e.g., `/home/ec2-user/`).**

## **`Configuring Application Properties`**

- **Update the following properties with your RDS details :-**

```sh
spring.datasource.url=jdbc:mysql://<RDS-ENDPOINT>:3306/your_database_name
spring.datasource.username=your-username_rds
spring.datasource.password=your-password_rds
```

## **`Running the Application`**

- **Once you have copied your JAR file to the EC2 instance and configured the application properties, you can run the application as follows :**

1. **Navigate to the Directory :**

   - **Open your SSH terminal (PuTTY) and navigate to the directory where you copied the JAR file**

   ```sh
   Type below Command to list the files in the Amazon Linux ec2-user terminal
   ls
   ```

2. **Run the Application :**

   - **Use the `nohup` command to run your JAR file in the background, allowing it to continue running even after you disconnect from the SSH session :**

   ```sh
   nohup java -jar your_jar_backend_application_name.jar &
   cat nohup.out
   ```

   - **`nohup`: This command runs the process immune to hangups.**
   - **`java -jar your-application.jar`: This command starts your Spring Boot application.**
   - **`nohup.out`: Standard output and Standard error to the `nohup.out` file.**
   - **`&`: This runs the command in the background.**

3. **Check Application Logs :**

   - **You can view the application logs to ensure it is running correctly :**

   ```sh
   tail -f nohup.out
   ```

## **API Endpoints Documentation**

**Documenting your API endpoints is crucial for users and developers who will interact with your application.**

### **`API Endpoints`**

- **`Base URL`** **`http://ec2-65-0-106-182.ap-south-1.compute.amazonaws.com:8090`**

### **`EndPoints`**

| `HTTP Method` |                   `API Endpoint`                   |            `Description`            |
| :-----------: | :------------------------------------------------: | :---------------------------------: |
|    **GET**    |        **`http://<baseurl>:8090/v1/tasks`**        |         Retrieve all tasks          |
|    **GET**    |     **`http://<baseurl>:8090/v1/tasks/{id}`**      |     Retrieve a task by its UUID     |
|   **POST**    |        **`http://<baseurl>:8090/v1/tasks`**        |          Create a new Task          |
|    **PUT**    |     **`http://<baseurl>:8090/v1/tasks/{id}`**      | Update an existing Task by its UUID |
|  **DELETE**   |     **`http://<baseurl>:8090/v1/tasks/{id}`**      | Delete an existing Task by its UUID |
|   **PATCH**   | **`http://<baseurl>:8090/v1/tasks/{id}/complete`** |       Mark a task as complete       |

## **`Test EndPoints AWS Live`**

- **`GET - Retrieve all tasks`**

  ```sh
  curl -X GET http://ec2-65-0-106-182.ap-south-1.compute.amazonaws.com:8090/v1/tasks
  ```

  ```sh
  Response
  [
   {
      "id": "4f652b56-8410-46a4-a9b4-d7de9a96e09c",
      "title": "Updated Task Title",
      "description": "Updated description of the task",
      "dueDate": "2024-12-09",
      "status": "COMPLETED"
   },
   {
      "id": "a6adfa05-d1fa-470a-b99c-b703ba39b19a",
      "title": "Wellness360 Software Engineering Intern.",
      "description": "Wellness360 Software Engineer Intern Last and Final Task EC2 Instance completed.",
      "dueDate": "2024-12-05",
      "status": "COMPLETED"
   }
  ]
  ```

### **`MS Word File for Complete Documentation with ScreenShots`**

- **[For Complete Documentation](https://1drv.ms/w/c/11be4e85e9cf4010/EaXNvamMCZZIqaYKHlhHQqcBMfWKQe6xpoQWyZtvDZipeA?e=mw4l6T)**

<br>

# **`Contribution`**

### Contributions are welcome! Please fork the repository and submit a pull request for review. Connect me on **[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=navy)](https://in.linkedin.com/in/bhimavarapu-manoj-kumar-reddy)**
