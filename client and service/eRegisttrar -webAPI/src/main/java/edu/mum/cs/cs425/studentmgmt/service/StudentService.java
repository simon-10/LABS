package edu.mum.cs.cs425.studentmgmt.service;

import java.util.List;
import edu.mum.cs.cs425.studentmgmt.model.Student;


public interface StudentService {
	
	List<Student> getAllStudents();
	Student registerNewStudent(Student newStudent);
    List<Student> getAllStudentsSorted();
    Student getStudentById(Long studentrId);
    Student updateStudent(Student editedStudent, Long student);
    void deleteStudentById(Long studentrId);
}
