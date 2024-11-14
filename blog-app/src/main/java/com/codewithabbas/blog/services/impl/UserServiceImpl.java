package com.codewithabbas.blog.services.impl;

import java.util.List; 
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithabbas.blog.entities.User;
import com.codewithabbas.blog.exceptions.RescourceNotFoundException;
import com.codewithabbas.blog.payloads.UserDto;
import com.codewithabbas.blog.repositories.UserRepository;
import com.codewithabbas.blog.services.UserService;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
 

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public UserDto createUser(UserDto userDto) { 
		User user = dtoToUser(userDto);
		user = userRepo.save(user);
		return this.userToDto(user);
	}
 
	@Override
	public UserDto updateUser(UserDto userDto, int id) { 
//		User user = this.userRepo.getById(id).orElseThrow(e -> new ResourceNotFoundException("User", " id", userId));

		User user;
		UserDto dto1;
		try {
			user = this.userRepo.getReferenceById(id);
			user.setName(userDto.getName());
			user.setEmail(userDto.getEmail());
			user.setId(userDto.getId());
			user.setPassword(userDto.getPassword());
			user.setAbout(userDto.getPassword());
			
			User userUpdated = this.userRepo.save(user);
			dto1 = this.userToDto(userUpdated);
			
		}catch(EntityNotFoundException e)
		{
			throw new RescourceNotFoundException("User", " id", id);
		}
		
		return dto1;
	}

	@Override
	public UserDto getUserById(int id) { 
		User user = this.userRepo.findById(id).orElseThrow(()-> new RescourceNotFoundException("user", "id", id));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() { 

		List<User> user = this.userRepo.findAll();
		
		List<UserDto> userDto = user.stream().map(userss -> this.userToDto(userss)).collect(Collectors.toList());
		
		return userDto;
	}

	@Override
	public void deleteUser(int id) { 
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(id).orElseThrow(()->new RescourceNotFoundException("user", "id", id));
		this.userRepo.delete(user);
		
	}
	
	
	public User dtoToUser(UserDto userDto) 
	{
		User user = this.modelMapper.map(userDto, User.class);
		
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getPassword());
		return user;
		
	}

	public UserDto userToDto(User user) 
	{
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
				
				
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getPassword());
		
		return userDto;
	}
	

}
