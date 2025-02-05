package com.example.studentprojects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentprojects.dao.PassportRepository;
import com.example.studentprojects.model.Passport;

import jakarta.transaction.Transactional;

@Service
public class PassportService {
	@Autowired
	private PassportRepository passportRepository;
	
	@Transactional
	public Passport save(Passport passport) {
		return passportRepository.save(passport);
	}

}
