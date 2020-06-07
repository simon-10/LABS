package edu.mum.cs.cs425.studentmgmt.service.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student registerNewStudent(Student newStudent) {
		return studentRepository.save(newStudent);
	}

	@Override
	public List<Student> getAllStudentsSorted() {
		return studentRepository.findAll(Sort.by("name"));
	}

	@Override
	public Student getStudentById(Long studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public Student updateStudent(Student editedStudent, Long studentId) {
		
	
	return studentRepository.findById(studentId).map(student->{
			student.setStudentNumber(editedStudent.getStudentNumber());
			student.setFirstName(editedStudent.getFirstName());
			student.setMiddleName(editedStudent.getFirstName());
			student.setLastName(editedStudent.getLastName());
			student.setCgpa(editedStudent.getCgpa());
			student.setClassroom(editedStudent.getClassroom());
			student.setDateOfEnrollment(editedStudent.getDateOfEnrollment());
			student.setTranscript(editedStudent.getTranscript());
			return studentRepository.save(student);}).orElseGet(()->{
				return studentRepository.save(editedStudent);});
	
}

	@Override
	public void deleteStudentById(Long studentId) {
		studentRepository.deleteById(studentId);
		
	}

	
}
	       


