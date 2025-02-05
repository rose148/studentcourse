package com.example.studentprojects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentprojects.dao.ReviewRepository;
import com.example.studentprojects.model.Review;

import jakarta.transaction.Transactional;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review findById(int id) {
		return reviewRepository.findById(id).get();
	}
	
	@Transactional
	public Review save(Review review) {
		return reviewRepository.save(review);
	}
	
	@Transactional
	public void remove(Review review) {
		reviewRepository.delete(review);
	}

}
