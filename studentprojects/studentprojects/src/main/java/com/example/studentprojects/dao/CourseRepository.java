package com.example.studentprojects.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentprojects.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
