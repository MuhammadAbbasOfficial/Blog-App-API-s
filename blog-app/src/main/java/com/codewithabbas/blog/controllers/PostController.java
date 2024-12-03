package com.codewithabbas.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithabbas.blog.payloads.PostDto;
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
	
	

}
