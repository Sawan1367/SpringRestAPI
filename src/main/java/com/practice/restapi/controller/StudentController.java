package com.practice.restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.restapi.dto.AddStudentRequestDTO;
import com.practice.restapi.dto.StudentDTO;
import com.practice.restapi.service.StudentService;

@RestController /*automatically returns the java object into JSON*/
@RequestMapping("") /*Whatever path I give will be universal for all the controllers specified in this java file*/
public class StudentController {

//    private final SpringRestAPI springRestAPI;
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService/*, SpringRestAPI springRestAPI*/) { 
		this.studentService = studentService; 
//		this.springRestAPI = springRestAPI;
	}
	
	@GetMapping("/student") /*during component scanning, it registers as handler method*/
	public ResponseEntity<List<StudentDTO>> getStudent() {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
		// or
		// return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("/student/{id}") 
	public ResponseEntity<StudentDTO> getStudentById() {
		return ResponseEntity.ok(studentService.getStudentById(4L)); /*It returns the status code of 200*/
	}
	
	@GetMapping("/student/{id}/{name}") 
	public String getStudentByIdAndName(@PathVariable Long id /*or @PathVariable("id") Long studentId*/, @PathVariable String name) {
		return "@PathVariable : " + id + " : " + name;
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<StudentDTO> createNewStudent(@RequestBody AddStudentRequestDTO addStudentRequestDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDTO));
	}
	
	@DeleteMapping("/deleteStudent")
	public ResponseEntity<Void> deleteStudent(@RequestParam Long id) {
		studentService.deleteStudentById(id);
		return ResponseEntity.noContent().build();
	}
}
