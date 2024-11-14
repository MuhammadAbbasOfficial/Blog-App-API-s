package com.codewithabbas.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithabbas.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
