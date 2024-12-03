package com.codewithabbas.blog.services;

import java.util.List;

import com.codewithabbas.blog.entities.Category;
import com.codewithabbas.blog.entities.Post;
import com.codewithabbas.blog.entities.User;
import com.codewithabbas.blog.payloads.PostDto;

public interface PostService {
	
	//create
	PostDto createPost(PostDto post, int userId, int categoryId);
	
	//update
	PostDto updatePost(PostDto post, int postId);
	
	//delete
	void deletPost(int postId);
	
	//get list of posts
	List<PostDto> getAllPosts();
	
	//get Post
	Post getPostById(int postId);
	
	//get post by categroy
	List<PostDto> getAllPostByCategory(Category category);
	
	//get Post by user
	List<PostDto> getPostByUser(User user);
	

}
