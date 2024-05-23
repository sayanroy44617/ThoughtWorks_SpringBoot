package com.tw.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping()
	public String getUsers( @RequestParam(value="page") int page , @RequestParam(value="limit") int limit ,
			@RequestParam(value="sort" , required = false)String sort   )
	{
		return "Getting the users  of page no :" + page + " and limit : " + limit + " sort : "+ sort ;
	}
	
	@GetMapping("/{userid}")
	public String getUser(@PathVariable String userid )
	{
		return "Getting the user with id: " + userid;
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
