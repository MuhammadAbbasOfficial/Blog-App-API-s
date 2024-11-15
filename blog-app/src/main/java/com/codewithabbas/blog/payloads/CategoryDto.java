package com.codewithabbas.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	    private Integer id;
	    @NotBlank
	    @Size(min= 4, message = "min size will be 4 char")
	    private String title;
	    @NotBlank
	    @Size(min = 10, message = "min size will be 10 char")
	    private String description;
	
}
