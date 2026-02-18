package com.practice.restapi.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.practice.restapi.dto.StudentDTO;
import com.practice.restapi.entity.Student;
import com.practice.restapi.repository.StudentRepository;
import com.practice.restapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepository;
	private final ModelMapper modelMapper;
	
	public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
		this.studentRepository = studentRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		List<StudentDTO> studentDtoList = students
				.stream()
				.map(student -> modelMapper.map(student, StudentDTO.class))
				.toList();
		return studentDtoList;
	}
	
	@Override
	public StudentDTO getStudentById(Long id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id : " + id));
		return modelMapper.map(student, StudentDTO.class);
	}
	
}
