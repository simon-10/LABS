package edu.mum.cs.cs425.demos.elibrary_springsec_1.service.impl;



import edu.mum.cs.cs425.demos.elibrary_springsec_1.model.Student;
import edu.mum.cs.cs425.demos.elibrary_springsec_1.repository.StudentRepository;
import edu.mum.cs.cs425.demos.elibrary_springsec_1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll(Sort.by("firstName"));

	}

	@Override
	public Page<Student> getAllStudentsPaged(int pageNo) {
		// TODO Auto-generated method stub
		return studentRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("firstName")));
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public void deleteStudentById(Long studentId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(studentId);
	}

	
	
	
	@Override
	 public List<Student> searchStudents(String searchString) {
		
		List<Student> studentnumber=studentRepository.findStudentsBystudentNumberContains(searchString);
		List<Student> firstname=studentRepository.findStudentsByfirstNameContains(searchString);
		List<Student> middlename=studentRepository.findStudentsBymiddleNameContains(searchString);
		List<Student> lastname=studentRepository.findStudentsBylastNameContains(searchString);
		if(firstname.size()!=0)
			return firstname;
		if(lastname.size()!=0)
			return lastname;
		if(middlename.size()!=0)
			return middlename;
		return studentnumber;
		
		}
}
	       


