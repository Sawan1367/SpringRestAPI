package com.practice.restapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//import lombok.AllArgsConstructor;
//import lombok.Data;

//@Data
//@AllArgsConstructor
public class StudentDTO {
	private Long id;

	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 30, message = "Name should be of length 3 to 30 characters")
	private String name;
	
	@Email
	@NotBlank(message = "Email is required")
	private String email;	
	
	public StudentDTO() {
	}

	public StudentDTO(Long id, String name, String email) {
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
