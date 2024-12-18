package com.codewithabbas.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codewithabbas.blog.entities.Category;
import com.codewithabbas.blog.entities.Post;
import com.codewithabbas.blog.entities.User;
import com.codewithabbas.blog.exceptions.RescourceNotFoundException;
import com.codewithabbas.blog.payloads.PostDto;
import com.codewithabbas.blog.payloads.PostResponse;
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
		Post postFinded = this.postRepo.findById(postId).orElseThrow(()-> new RescourceNotFoundException("post", "post id", postId));
		Post updatedPost = this.modelMapper.map(post, Post.class);

		postFinded.setTitle(post.getTitle());
		postFinded.setCategory(updatedPost.getCategory());
		postFinded.setContent(post.getContent());
		postFinded.setImageName(post.getImageName());
		postFinded.setUser(updatedPost.getUser());
		
		return this.modelMapper.map(postFinded, PostDto.class);
	}

	@Override
	public void deletPost(int postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new RescourceNotFoundException("post", "Post id", postId));
		this.postRepo.delete(post);
	}

	@Override
	public PostResponse getAllPosts(int pageNumber, int pageSize) {
		
		Pageable page = PageRequest.of(pageNumber, pageSize);
		Page<Post> pagerPost = this.postRepo.findAll(page);
		List<Post> allPosts = pagerPost.getContent(); 
		List<PostDto> allPostDto = allPosts.stream().map((postss)-> this.modelMapper.map(postss, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		
		postResponse.setContent(allPostDto);
		postResponse.setPageNumber(pagerPost.getNumber());
		postResponse.setPageSize(pagerPost.getSize());
		postResponse.setTotalElements(pagerPost.getTotalElements());
		postResponse.setTotalPages(pagerPost.getTotalPages());
		postResponse.setLastPage(pagerPost.isLast());
		
		return postResponse;
	}

	@Override
	public PostDto getPostById(int postId) {
		// TODO Auto-generated method stub
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new RescourceNotFoundException("post", "post id", postId));
		PostDto postDto = this.modelMapper.map(post, PostDto.class);
		return postDto;
	}

	@Override
	public List<PostDto> getAllPostByCategory(int categoryId) {
		
//		Pageable pageAble = PageRequest.of(pageNumber, pageSize);
//		Page<Post> pagePost = this.postRepo.findAll(pageAble);
//		List<Post> allPosts = pagePost.getContent();
		
		Category cat = this.catRepo.findById(categoryId).orElseThrow(()-> new RescourceNotFoundException("category", "category id" , categoryId));		
		List<Post> posts = this.postRepo.findByCategory(cat);
		
		List<PostDto> postDto = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
//		PostResponse postRes = new PostResponse();
		
		
		
		return postDto;
	}

	@Override
	public List<PostDto> getPostByUser(int userId) { 
		User user = this.userRepo.findById(userId).orElseThrow(()-> new RescourceNotFoundException("User", "USER ID ", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		
		List<PostDto> postDto = posts.stream().map(
				(post)-> 
				this.modelMapper.map(post, PostDto.class)
		).collect(Collectors.toList());
		
		
		return postDto;
	}

	
	
	
	
}
