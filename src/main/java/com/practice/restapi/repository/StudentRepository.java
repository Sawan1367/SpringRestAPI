package com.practice.restapi.repository;

//import java.util.List;

//import org.springframework.data.domain.Pageable;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.restapi.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByName(String name);
	
	
	/**
	 * JPQL
	 * Hibernate converts JPQL to SQL to work internally	 * 
	 */
	
//	@Query("SELECT s FROM student s WHERE s.name LIKE %s%")
//	List<Student> studentsHavingSInTheirName();
	
//	@Query("SELECT * FROM student WHERE name = ?1")
	// or
//	@Query("SELECT * FROM student WHERE name = :name")
//	Student studentWhereNameIs(@Param("name") String name)
	
	
	
	
	/**
	 * Pure SQL Query
	 */
//	@Query("SELECT s FROM student s WHERE LOWER(s.name) LIKE %s%", nativeQuery = true)
//	List<Student> studentsHavingSInTheirName();
	
	
	/**
	 * For update queries, we must use @Transactional and @Modifying
	 */
	
//	@Transactional
//	@Modifying
//	@Query("UPDATE QUERY")
//	List<Student> updateStudentWithName(Pageable pageable);	
}
