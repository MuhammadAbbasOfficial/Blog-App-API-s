package com.codewithabbas.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithabbas.blog.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	

}
