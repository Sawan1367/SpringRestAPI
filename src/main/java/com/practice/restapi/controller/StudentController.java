package com.practice.restapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.restapi.dto.StudentDTO;
import com.practice.restapi.service.StudentService;

@RestController /*automatically returns the java object into JSON*/
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) { 
		this.studentService = studentService;
	}
	
	@GetMapping("/student") /*during component scanning, it registers as handler method*/
	public List<StudentDTO> getStudent() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{id}") 
	public StudentDTO getStudentById() {
		return studentService.getStudentById(4L);
	}
	
	@GetMapping("/student/{id}/{name}") 
	public String getStudentByIdAndName(@PathVariable Long id /*or @PathVariable("id") Long studentId*/, @PathVariable String name) {
		return "@PathVariable : " + id + " : " + name;
	}
}
