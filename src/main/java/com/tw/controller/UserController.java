package com.tw.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String getUser()
	{
		return "Getting all the users " ;
	}
	
	@PostMapping
	public String addUser()
	{
		return "Added a new user";
	}
	
	@PutMapping
	public String updateUser()
	{
		return "Updated a eser " ;
	}
	
	@DeleteMapping
	public String DeleteUser()
	{
		return "Deleted a user";
	}

}
