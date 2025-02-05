package com.example.studentprojects.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentprojects.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
