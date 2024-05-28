package com.example.bufsroom.service;

import com.example.bufsroom.DataNotFoundException;
import com.example.bufsroom.repository.UserRepository;
import com.example.bufsroom.user.SiteUser;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public SiteUser create(String userid, String password) {
		SiteUser user = new SiteUser();
		user.setUserid(userid);
		user.setPassword(passwordEncoder.encode(password));

		this.userRepository.save(user);
		return user;
	}
}
