package edu.mum.cs.cs425.studentmgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import edu.mum.cs.cs425.studentmgmt.model.Student;


public interface StudentService {
	 public List<Student> getAllStudents();
	 public  Page<Student> getAllStudentsPaged(int pageNo);
	 public  Student saveStudent(Student student);
	 public  Student getStudentById(Long studentId);
	void deleteStudentById(Long studentId);
	 public List<Student> searchStudents(String searchString);

}
