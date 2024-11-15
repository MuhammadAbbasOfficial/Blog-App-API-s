package com.codewithabbas.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithabbas.blog.entities.Category;
import com.codewithabbas.blog.exceptions.RescourceNotFoundException;
import com.codewithabbas.blog.payloads.CategoryDto;
import com.codewithabbas.blog.repositories.CategoryRepo;
import com.codewithabbas.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ModelMapper modelMapper;
	

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
		

		Category cat = this.categoryRepo.findById(id).orElseThrow(()-> new RescourceNotFoundException("Category", "category ID: ", id));
		
		cat.setTitle(categoryDto.getTitle());
		cat.setDescription(categoryDto.getDescription());
		
		Category updateCat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updateCat, CategoryDto.class);
	}

	@Override
	public void deletCategory(int id) {
		
		Category cat = this.categoryRepo.findById(id).orElseThrow(()-> new RescourceNotFoundException("Category", "Category id", id));
		
		this.categoryRepo.delete(cat);
		
	}

	@Override
	public CategoryDto getCategory(int id) {

		Category cat = this.categoryRepo.findById(id).orElseThrow(()-> new RescourceNotFoundException("Category ", "category id", id));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categoryList = this.categoryRepo.findAll();
		List<CategoryDto> catDto = categoryList.stream().map(
				(cat)->
				this.modelMapper.map(cat, CategoryDto.class)
				).collect(Collectors.toList());
		return catDto;
	}

}
