package com.example.studentprojects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.studentprojects.model.Passport;
import com.example.studentprojects.model.Student;
import com.example.studentprojects.service.PassportService;
import com.example.studentprojects.service.StudentService;

@Controller
@RequestMapping("/passports")
public class PassportController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private PassportService passportService;
	
	@GetMapping("/add")
	public String add(Model model, @RequestParam("id") int id)
	{
		Passport thePassport = new Passport();
		model.addAttribute("thePassport", thePassport);
		model.addAttribute("id", id);
		return "passport-form";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @ModelAttribute("thePassport") Passport thePassport)
	{
		Student student = studentService.findById(id);
		thePassport.setStudent(student);
		passportService.save(thePassport);
		student.setPassport(thePassport);
		studentService.save(student);
		return "redirect:/students";
	}
	

}
