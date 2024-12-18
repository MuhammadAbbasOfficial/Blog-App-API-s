package com.codewithabbas.blog.payloads;

import java.util.Date;

import com.codewithabbas.blog.entities.Category;
import com.codewithabbas.blog.entities.User;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private int postId;

	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
}
