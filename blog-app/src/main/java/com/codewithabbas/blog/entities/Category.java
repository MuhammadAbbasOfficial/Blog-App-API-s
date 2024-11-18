	package com.codewithabbas.blog.entities;
	
	import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;
	
	@Entity
	@Table(name = "categories")
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	public class Category {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		Integer id ;
		
		@Column(name = "title", length = 100, nullable = false)
		String title;
		
		@Column(name = "description")
		String description;
		
		@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<Post> post = new ArrayList<Post>();
		
	}
