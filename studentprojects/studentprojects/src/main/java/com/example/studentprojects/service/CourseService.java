package com.example.studentprojects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentprojects.dao.CourseRepository;
import com.example.studentprojects.model.Course;

import jakarta.transaction.Transactional;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	
	public Course findById(int id) {
		return courseRepository.findById(id).get();
	}
	
	@Transactional
	public Course save(Course course) {
		return courseRepository.save(course);
	}

}
