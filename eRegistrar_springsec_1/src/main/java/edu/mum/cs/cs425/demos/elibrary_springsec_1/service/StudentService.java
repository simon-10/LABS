package edu.mum.cs.cs425.demos.elibrary_springsec_1.service;

import edu.mum.cs.cs425.demos.elibrary_springsec_1.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;


public interface StudentService {
	 public List<Student> getAllStudents();
	 public  Page<Student> getAllStudentsPaged(int pageNo);
	 public  Student saveStudent(Student student);
	 public  Student getStudentById(Long studentId);
	void deleteStudentById(Long studentId);
	 public List<Student> searchStudents(String searchString);

}
