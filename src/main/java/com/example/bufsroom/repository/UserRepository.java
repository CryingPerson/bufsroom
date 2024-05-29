package com.example.bufsroom.repository;

import java.util.Optional;

import com.example.bufsroom.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	Optional<SiteUser> findByUsername(String username);
}