package com.example.studentprojects.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentprojects.model.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Integer> {

}
