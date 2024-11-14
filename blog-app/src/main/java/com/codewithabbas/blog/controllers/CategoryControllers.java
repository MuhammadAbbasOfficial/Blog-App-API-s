package com.codewithabbas.blog.controllers;

import java.net.http.HttpResponse;
import java.util.List;

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
import com.codewithabbas.blog.payloads.CategoryDto;
import com.codewithabbas.blog.services.CategoryService;
import com.codewithabbas.blog.services.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryControllers {
	
	@Autowired
	CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto catDto)
	{
		CategoryDto catDtos = this.categoryService.createCategory(catDto);
		return new ResponseEntity<CategoryDto>(catDtos, HttpStatus.CREATED);
	}
	
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto catDto, @PathVariable int id)
	{
		CategoryDto catDtos = this.categoryService.updateCategory(catDto, id);
		
		
		return new ResponseEntity<CategoryDto>(catDtos, HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int id)
	{
		this.categoryService.deletCategory(id);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully.", true), HttpStatus.OK);
	}
	
	//get
	
	@GetMapping("{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable int id)
	{
		CategoryDto cat = this.categoryService.getCategory(id);
		return new ResponseEntity<CategoryDto>(cat, HttpStatus.OK);
	}
	
	
	
	//getall
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories()
	{
		List<CategoryDto> allCategories = this.categoryService.getAllCategories();					
		return new ResponseEntity<List<CategoryDto>>(allCategories, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
