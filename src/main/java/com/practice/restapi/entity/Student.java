package com.practice.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
//import lombok.Getter;
//import lombok.Setter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

@Entity
@Table(
		name = "student",
		uniqueConstraints = {
				@UniqueConstraint(name = "unique_id", columnNames = {"id"}),
				@UniqueConstraint(name = "unique_email", columnNames = {"email"})
				/**
				 * @UniqueConstraint(name = "unique_id_and_email", columnNames = {"id", "email"})
				 * 
				 * It will say that both id and email together cannot be same for 2 entities
				 */
		},
		indexes = {
				@Index(name = "idx_id", columnList = "id")
		}
	)
@Getter
@Setter
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@ToString.Exclude
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	public Student() {}

	public Student(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
