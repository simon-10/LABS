package edu.mum.cs.cs425.studentmgmt.service.impl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;

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
	 public Page<Student> searchStudents(String searchString, int pageNo) {
		Page<Student> firstname=studentRepository.findStudentsByfirstNameContains(searchString,PageRequest.of(pageNo,3));
		Page<Student> studentnumber=studentRepository.findStudentsBystudentNumberContains(searchString,PageRequest.of(pageNo,3));
		Page<Student> lastname=studentRepository.findStudentsBylastNameContains(searchString,PageRequest.of(pageNo,3));

		if(firstname.getNumberOfElements()!=0)
			return firstname;
		if(lastname.getNumberOfElements()!=0)
			return lastname;
		return studentnumber;
		
		}
}
	       


