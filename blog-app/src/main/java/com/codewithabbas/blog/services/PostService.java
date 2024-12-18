package com.codewithabbas.blog.services;

import java.util.List;

import com.codewithabbas.blog.entities.Category;
import com.codewithabbas.blog.entities.Post;
import com.codewithabbas.blog.entities.User;
import com.codewithabbas.blog.payloads.PostDto;
import com.codewithabbas.blog.payloads.PostResponse;

public interface PostService {
	
	//create
	PostDto createPost(PostDto post, int userId, int categoryId);
	
	//update
	PostDto updatePost(PostDto post, int postId);
	
	//delete
	void deletPost(int postId);
	
	//get list of posts
	PostResponse getAllPosts(int pageNumber, int pageSize);
	
	//get Post
	PostDto getPostById(int postId);
	
	//get post by categroy
//	PostDto getAllPostByCategory(int categoryId, int pageNumber, int pageSize);
	
	List<PostDto> getAllPostByCategory(int categoryId);
	
	//get Post by user
	List<PostDto> getPostByUser(int userId);
	

}
