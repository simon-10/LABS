package edu.mum.cs.cs425.studentmgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.studentmgmt.model.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{


	
	List<Student> findStudentsBystudentNumberContains(String searchString);
	List<Student> findStudentsByfirstNameContains(String searchString);
	List<Student> findStudentsBymiddleNameContains(String searchString);
	List<Student> findStudentsBylastNameContains(String searchString);



}
