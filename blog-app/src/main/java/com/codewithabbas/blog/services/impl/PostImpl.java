package com.codewithabbas.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithabbas.blog.entities.Category;
import com.codewithabbas.blog.entities.Post;
import com.codewithabbas.blog.entities.User;
import com.codewithabbas.blog.exceptions.RescourceNotFoundException;
import com.codewithabbas.blog.payloads.PostDto;
import com.codewithabbas.blog.repositories.CategoryRepo;
import com.codewithabbas.blog.repositories.PostRepo;
import com.codewithabbas.blog.repositories.UserRepository;
import com.codewithabbas.blog.services.PostService;


@Service
public class PostImpl implements PostService {
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CategoryRepo catRepo;
	

	@Override
	public PostDto createPost(PostDto post, int userId, int categoryId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new RescourceNotFoundException("User", "user id", userId));
		Category cat = this.catRepo.findById(categoryId).orElseThrow(()-> new RescourceNotFoundException("category", "category id ", categoryId));
		
		Post postAdd = this.modelMapper.map(post, Post.class);
		postAdd.setImageName("defaultImage.png");
		postAdd.setAddedDate(new Date());
		postAdd.setCategory(cat);
		postAdd.setUser(user);
		
		Post post2 = this.postRepo.save(postAdd);
		return this.modelMapper.map(post2, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto post, int postId) {
		Optional<Post> postFind = this.postRepo.findById(postId);
		
		
		
		return null;
	}

	@Override
	public void deletPost(int postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostDto> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPostByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
