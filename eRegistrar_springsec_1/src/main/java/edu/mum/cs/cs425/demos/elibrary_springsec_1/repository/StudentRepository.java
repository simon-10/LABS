package edu.mum.cs.cs425.demos.elibrary_springsec_1.repository;

import edu.mum.cs.cs425.demos.elibrary_springsec_1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{


	
	List<Student> findStudentsBystudentNumberContains(String searchString);
	List<Student> findStudentsByfirstNameContains(String searchString);
	List<Student> findStudentsBymiddleNameContains(String searchString);
	List<Student> findStudentsBylastNameContains(String searchString);



}
