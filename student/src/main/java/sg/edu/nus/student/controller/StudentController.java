package sg.edu.nus.student.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.student.model.Student;
import sg.edu.nus.student.repo.StudentRepository;
import sg.edu.nus.student.validator.StudentValidator;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	  @InitBinder
	  protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new StudentValidator());
	  }


	@Autowired
	StudentRepository srepo;

	@RequestMapping("/all")
	public String findAllStudents(Model model) {
		ArrayList<Student> all = new ArrayList<Student>();
		all.addAll(srepo.findAll());
		model.addAttribute("students", all);
		return "slisting";
	}

	@RequestMapping("/load")
	public String loadStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "sform";
	}

	@PostMapping("/addstudent")
	public String addStudent(@ModelAttribute("student") @Valid Student student, BindingResult bingResult) {
		if (bingResult.hasErrors()) {
			return "sform";
		}
		srepo.saveAndFlush(student);
		return "forward:/student/all";

	}

	@RequestMapping("/editload/{id}")
	public String loadEditStudentForm(@PathVariable("id") Integer id, Model model) {
		Student s = srepo.findById(id).get();
		model.addAttribute("student", s);
		return "sform";
	}

	@RequestMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable("id") Integer id, Model model) {
		Student s = srepo.findById(id).get();
		srepo.delete(s);
		return "forward:/student/all";
	}

}
