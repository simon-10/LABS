package edu.mum.cs.cs425.demos.elibrary_springsec_1.controller;


import edu.mum.cs.cs425.demos.elibrary_springsec_1.model.Student;
import edu.mum.cs.cs425.demos.elibrary_springsec_1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class StudentController {
	
	
	
	private StudentService studentService;
	
	
	
	@Autowired
    public StudentController(StudentService studentService) {
		
		this.studentService = studentService;
	}

	@GetMapping(value = {"/eregistrar/secured/services/list"})
    public ModelAndView listStudents(@RequestParam(defaultValue = "0") int pageno, Model model) {
		//model.addAttribute(studentService.getAllStudentsPaged(pageno));
		
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudentsPaged(pageno));
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.addObject("studentsCount", studentService.getAllStudents().size());
        modelAndView.setViewName("secured/list");
        return modelAndView;
    }

    @GetMapping(value = {"/eregistrar/secured/services/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "secured/new";
    }

    @PostMapping(value = {"/eregistrar/secured/services/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            System.out.println("inside error");
            return "secured/new";
        }
        
        student = studentService.saveStudent(student);
        System.out.println("outside");
        return "redirect:/eregistrar/secured/services/list";
    }

    @GetMapping(value = {"/eregistrar/secured/services/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {
        Student student = studentService .getStudentById(studentId);
        if (student != null) {
        	System.out.println("not null");
            model.addAttribute("student", student);
            return "secured/edit";
        }
        return "secured/list";
    }

    @PostMapping(value = {"/eregistrar/secured/services/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/secured/services/list";
    }

    @GetMapping(value = {"/eregistrar/secured/services/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/secured/services/list";
    }
    
    
    
    @GetMapping(value = {"/eregistrar/secured/services/search", "/services/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("secured/list");
        return modelAndView;
    }
}
