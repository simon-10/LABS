package edu.mum.cs.cs425.studentmgmt.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;



@Controller
public class StudentController {
	
	
	
	private StudentService studentService;
	
	 
	
	@Autowired
    public StudentController(StudentService studentService) {
		
		this.studentService = studentService;
	}

	@GetMapping(value = {"/eregistrar/student/list"})
    public ModelAndView listBooks(@RequestParam(value = "pageN", defaultValue = "0") int pageno) {
	    Page<Student> pages=studentService.getAllStudentsPaged(pageno);
	    System.out.println("page number"+pageno);
        Long totalItems=pages.getTotalElements();
        int totalPages=pages.getTotalPages();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", pages);
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.addObject("totalItems", totalItems);
        modelAndView.addObject("totalPages", totalPages);

        modelAndView.setViewName("student/list");
        return modelAndView;
    }


    @GetMapping("/eregistrar/student/lists/{page}")
    public ModelAndView listBooks2(@PathVariable(value="page") int pageno) {
        Page<Student> pages=studentService.getAllStudentsPaged(pageno);
        System.out.println("page number"+pageno);
        Long totalItems=pages.getTotalElements();
        int totalPages=pages.getTotalPages();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", pages);
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.addObject("totalItems", totalItems);
        modelAndView.addObject("totalPages", totalPages);

        modelAndView.setViewName("student/list");
        return modelAndView;
    }


    @GetMapping(value = {"/eregistrar/student/new"})
    public String displayNewBookForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/new";
    }

    @PostMapping(value = {"/eregistrar/student/new"})
    public String addNewBook(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/edit/{studentId}"})
    public String editBook(@PathVariable Long studentId, Model model) {
        Student student = studentService .getStudentById(studentId);
        if (student != null) {
        	System.out.println("not null");
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = {"/eregistrar/student/edit"})
    public String updateBook(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/delete/{studentId}"})
    public String deleteBook(@PathVariable Long studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/student/list";
    }
    
    
    
    @GetMapping(value = {"/eregistrar/student/search/{pageNo}"})
    public ModelAndView searchBooks(@RequestParam String searchString, @PathVariable int pageNo) {
        ModelAndView modelAndView = new ModelAndView();
        Page<Student> pages = studentService.searchStudents(searchString,pageNo);

        System.out.println("page number"+pageNo);
        Long totalItems=pages.getTotalElements();
        int totalPages=pages.getTotalPages();

        modelAndView.addObject("students", pages);
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.addObject("totalItems", totalItems);
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("searchString", searchString);

        modelAndView.setViewName("student/list");

        return modelAndView;
    }
}
