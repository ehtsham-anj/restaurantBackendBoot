package com.boot.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.project.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//findBy + fieldName
    Optional<User> findByUsername(String username);
}
