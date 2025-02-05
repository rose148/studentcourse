package com.example.studentprojects.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentprojects.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
