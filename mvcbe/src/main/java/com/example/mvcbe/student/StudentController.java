package com.example.mvcbe.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class StudentController { //currently no view page, just return the values API style
	@Autowired
	StudentRepository srepo;
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return srepo.findAll();
	}
	
	@PostMapping("/students") //posting form from the same page
	public Student createStudent(@RequestBody Student student)
	{
		Student result = srepo.save(student);
		return result;
	}


}
