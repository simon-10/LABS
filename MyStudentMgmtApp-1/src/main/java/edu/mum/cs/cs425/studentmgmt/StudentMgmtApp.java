package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;

@SpringBootApplication
@Transactional
public class StudentMgmtApp implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Classroom room1=new Classroom("McLaughlin building", "M105");
		
		Transcript t1=new Transcript("BS Computer Science");
		Student s1=new Student(" 000-61-0001","Anna","Lynn","Smith",3.45,LocalDate.of(2019, 5, 24),t1);
		
		Transcript t2=new Transcript("Msc Computer Science");
		Student s2=new Student(" 1030-61-0001","Simon","Abraham","welde",3.98,LocalDate.of(2020, 8, 12),t2);
		
		s1.setClassroom(room1);
		s2.setClassroom(room1);
		
		Student savedStudent1=saveStudent(s1);
		Student savedStudent2=saveStudent(s2);
		
		System.out.println(savedStudent1);
		System.out.println(savedStudent2);


		
		
		
		
	}
	
	private Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

}
