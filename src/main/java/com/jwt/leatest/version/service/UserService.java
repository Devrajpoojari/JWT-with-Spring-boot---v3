package com.jwt.leatest.version.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.leatest.version.model.User;
import com.jwt.leatest.version.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	public User addUser(User u) {
		u.setPassword(encoder.encode(u.getPassword()));
		return userRepo.save(u);
	}

	public User getUser(Integer id) {
		return userRepo.findById(id).get();
	}

}
