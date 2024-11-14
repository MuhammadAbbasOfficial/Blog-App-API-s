package com.codewithabbas.blog.services;

import java.util.List;

import com.codewithabbas.blog.payloads.CategoryDto;

public interface CategoryService {
	
	
	//create
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	
	//update
	 CategoryDto updateCategory(CategoryDto categoryDto, int id);
	
	//delete
	 void deletCategory(int id);
	
	//get
	CategoryDto getCategory(int id);
	 
	 
	//getAll
	List<CategoryDto> getAllCategories();

}
