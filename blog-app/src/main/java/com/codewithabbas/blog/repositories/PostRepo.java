package com.codewithabbas.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithabbas.blog.entities.Category;
import com.codewithabbas.blog.entities.Post;
import com.codewithabbas.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	
	List<Post> findByCategory(Category category);
	List<Post> findByUser(User user);
	

}
