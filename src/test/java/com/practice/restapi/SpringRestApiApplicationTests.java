package com.practice.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.practice.restapi.entity.Student;
import com.practice.restapi.repository.StudentRepository;

@SpringBootTest
class SpringRestApiApplicationTests extends AbstractTestNGSpringContextTests {
	
	@Autowired 
	private StudentRepository studentRepository;

	@Test
	public void testRepository() {
		List<Student> students = studentRepository.findAll();
		System.out.println(students);
	}
	
	@Test
	public void testFindByName() {
		Student student = studentRepository.findByName("Riya");
		System.out.println(student/*.getName()*/);
	}

}
