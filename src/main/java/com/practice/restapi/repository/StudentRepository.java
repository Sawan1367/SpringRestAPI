package com.practice.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.restapi.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
