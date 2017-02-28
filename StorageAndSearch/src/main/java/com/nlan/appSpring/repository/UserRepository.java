package com.nlan.appSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlan.appSpring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
