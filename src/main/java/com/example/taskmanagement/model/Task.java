package com.example.taskmanagement.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Task")
@Table(name = "tasks", 
		uniqueConstraints = 
		@UniqueConstraint(columnNames = {"task_id"}, 
		name = "task_id_unique"))
public class Task implements Serializable {
	
	private static final long serialVersionUID = -9102496759180974133L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@UuidGenerator(style = Style.RANDOM)
	@JdbcTypeCode(value = java.sql.Types.VARCHAR)
	@Column(name = "task_id", 
			updatable = false, 
			nullable = false, 
			unique = true, 
			columnDefinition = "VARCHAR(36)", 
			length = 36)
	private UUID id;
	
	@Column(name = "task_title",
			nullable = false,
			columnDefinition = "VARCHAR(60)")
	private String title;
	
	@Column(name = "task_description",
			nullable = false,
			columnDefinition = "VARCHAR(255)")
	private String description;
	
	@Column(name = "task_due_date",
			nullable = false,
			columnDefinition = "DATE")
	@Temporal(value = TemporalType.DATE)
	private LocalDate dueDate;
	
	@Column(name = "task_status",
			nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Status status;
	
	@Column(name = "task_created_at",
			nullable = false,
			updatable = false,
			columnDefinition = "TIMESTAMP")
	@CreationTimestamp(source = SourceType.VM)
	private LocalDateTime createdAt;
	
	@Column(name = "task_updated_at",
			columnDefinition = "TIMESTAMP")
	@UpdateTimestamp(source = SourceType.VM)
	private LocalDateTime updatedAt;
	
	private LocalDateTime localDateTime() {
		LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
		return now;
	}
	
	@PrePersist
	private void onPrePersist() {
		this.createdAt = localDateTime();
		this.updatedAt = localDateTime();
		this.status = Status.PENDING;
	}
	
	@PreUpdate
	private void onPreUpdate() {
		this.updatedAt = localDateTime();
	}
}