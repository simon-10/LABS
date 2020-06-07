package edu.mum.cs.cs425.studentmgmt.control;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;


@RestController
@RequestMapping(value="/eregistrar/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(allowedHeaders="*")
public class StudentRestController {

    private StudentService studentService;
    
    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list")
    public List<Student> list() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/get/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping(value = "/register")
    public Student registerNewStudent(@Valid @RequestBody Student student) {
        return studentService.registerNewStudent(student);
    }

    @PutMapping(value = "/update/{studentId}")
    public Student updatePublisher(@Valid @RequestBody Student editedStudent, @PathVariable Long studentId) {
        return studentService.updateStudent(editedStudent, studentId);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public void deletePublisher(@PathVariable Long studentId) {
    	studentService.deleteStudentById(studentId);
    }
}
