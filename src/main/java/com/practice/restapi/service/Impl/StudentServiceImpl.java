package com.practice.restapi.service.Impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.practice.restapi.dto.AddStudentRequestDTO;
import com.practice.restapi.dto.StudentDTO;
import com.practice.restapi.entity.Student;
import com.practice.restapi.repository.StudentRepository;
import com.practice.restapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepository;
	private final ModelMapper modelMapper;
	
	/**
	 * At back-end Hibernate is using EntityManager for all the .presist(), etc. other operations performed in Hibernate Lifecycle
	 * 
	 * As long as we are inside the persistence stage, and make any changes then we do not explicitly need to call for .save() or .persist() method
	 * It will be automatically be done by the persistence stage, this is what we call Dirty Check.
	 * 
	 * @param studentRepository
	 * @param modelMapper
	 */
	
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
//		Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id : " + id));
		// or		
		Optional<Student> student1 = studentRepository.findById(id);
		Optional<Student> student2 = studentRepository.findById(id);
		/**
		 * Here, I am checking that my Persistence Context is acting as first level cache
		 * When we first call .findById(id) then it will call the database
		 * but when we say it for the second time then it returns the same object from the persistence state
		 * saving the time delay or time spent to hit the DB
		 */
		System.out.println(student1 == student2);
		return modelMapper.map(student1, StudentDTO.class);
	}

	@Override
	public StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO) {
		Student newStudent = modelMapper.map(addStudentRequestDTO, Student.class);
		Student student = studentRepository.save(newStudent);
		return modelMapper.map(student, StudentDTO.class);
	}

	@Override
	public void deleteStudentById(Long id) {
		if(!studentRepository.existsById(id)) {
			throw new IllegalArgumentException("Student doesn't exists with id : " + id);
		}
		studentRepository.deleteById(id);
	}
	
}
