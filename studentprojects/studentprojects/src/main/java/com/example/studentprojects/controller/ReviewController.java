package com.example.studentprojects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.studentprojects.model.Course;
import com.example.studentprojects.model.Review;
import com.example.studentprojects.service.CourseService;
import com.example.studentprojects.service.ReviewService;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/add")
	public String add(Model model, @RequestParam("id") int id)
	{
		Review theReview = new Review();
		model.addAttribute("theReview", theReview);
		model.addAttribute("id", id);
		return "review-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("theReview") Review theReview, @RequestParam("id") int id)
	{
		Course course = courseService.findById(id);
		theReview.setCourse(course);
		reviewService.save(theReview);
		course.addReview(theReview);
		courseService.save(course);
		return "redirect:/courses/"+id;
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("id") int id, @RequestParam("cid") int cid)
	{
		Course course = courseService.findById(cid);
		Review review = reviewService.findById(id);
		course.removeReview(review);
		courseService.save(course);
		reviewService.remove(review);
		return "redirect:/courses/"+cid;
	}

}
