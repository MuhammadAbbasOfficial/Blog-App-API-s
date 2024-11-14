package com.codewithabbas.blog.controllers;

import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithabbas.blog.exceptions.ApiResponse;
import com.codewithabbas.blog.payloads.UserDto;
import com.codewithabbas.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;
	
	
	//create Api
	@PostMapping("/khan")
	public ResponseEntity<UserDto> creatUser(@Valid @RequestBody UserDto userDto){
		UserDto userDto1 = this.userService.createUser(userDto);
		return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
	}
	
	
	//update user Api
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable int userId)
	{
		UserDto userDto1 = this.userService.updateUser(userDto, userId);
		return new ResponseEntity<>(userDto1, HttpStatus.OK);
	}
	
	//delete user Api
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId)
	{
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
	}
	
	
	//get All Users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getOneUser(@PathVariable int userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
