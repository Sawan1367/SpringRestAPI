package com.practice.restapi.service;

import java.util.List;

import com.practice.restapi.dto.AddStudentRequestDTO;
import com.practice.restapi.dto.StudentDTO;

public interface StudentService {
	List<StudentDTO> getAllStudents();
	StudentDTO getStudentById(Long id);
	StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);
	void deleteStudentById(Long id);
}
