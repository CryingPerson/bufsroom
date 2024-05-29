package com.example.bufsroom.service;

import java.util.Optional;

import com.example.bufsroom.DataNotFoundException;
import com.example.bufsroom.repository.UserRepository;
import com.example.bufsroom.user.SiteUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public SiteUser create(String username, String password) {
		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setRole("USer");
		user.setPassword(passwordEncoder.encode(password));
		this.userRepository.save(user);
		return user;
	}

	public SiteUser getUser(String username) {
		Optional<SiteUser> siteUser = this.userRepository.findByUsername(username);
		if (siteUser.isPresent()) {
			return siteUser.get();
		} else {
			throw new DataNotFoundException("siteuser not found");
		}
	}
}