package com.codewithabbas.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
	
	
	private int id;
	
	@NotEmpty
	@Size(min =  4, message = "User Name must be 4 char")
	private String name;
	
	@Email(message = "Email Adress not valid.")
	private String email;
	
	@NotEmpty
	@Size(min=6, max = 12, message = "Minimum 6 char and maximum 12 characters")
	private String password;
	
	@NotEmpty
	private String about;  

}
