package com.codewithabbas.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithabbas.blog.entities.Post;
import com.codewithabbas.blog.exceptions.ApiResponse;
import com.codewithabbas.blog.payloads.PostDto;
import com.codewithabbas.blog.payloads.PostResponse;
import com.codewithabbas.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	
	@Autowired
	PostService postService;
	
	
	//create post
	@PostMapping("/user/{userId}/category/{catId}/posts")
	public ResponseEntity<PostDto> creatPost(@RequestBody PostDto post, 
			@PathVariable int userId, @PathVariable int catId){
		
		PostDto post2 = this.postService.createPost(post, userId, catId);
		
		return new ResponseEntity<PostDto>(post2, HttpStatus.CREATED);
		
	}
	
	//get all posts by user id
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable int userId)
	{
		List<PostDto> posts = postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	//get all posts by categories
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable int categoryId)
	{
		List<PostDto> allPostByCategory = this.postService.getAllPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(allPostByCategory, HttpStatus.OK);
	}
	// get all posts
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize, 
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber
	)
	{
		
		PostResponse allPosts = this.postService.getAllPosts(pageNumber, pageSize);
		return new ResponseEntity<PostResponse>(allPosts, HttpStatus.OK);
	}
	//get post by id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable int postId)
	{
		PostDto postsss = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postsss, HttpStatus.OK);
	}
	
	
	//delete Post
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable int postId)
	{
		this.postService.deletPost(postId);
		return new ApiResponse("Post Successfully Deleted.", true);
	}
	
	//update Post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable int postId)
	{
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
	}

}
