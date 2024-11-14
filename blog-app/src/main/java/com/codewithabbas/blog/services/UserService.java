package com.codewithabbas.blog.services;

import java.util.List;

import com.codewithabbas.blog.payloads.UserDto;

public interface UserService {
	
	
	public UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, int id);
	
	UserDto getUserById(int id);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(int id);
	
	

}
