package com.example.studentprojects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentprojects.dao.StudentRepository;
import com.example.studentprojects.model.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public Student findById(int id) {
		return studentRepository.findById(id).get();
	}
	
	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}

}
