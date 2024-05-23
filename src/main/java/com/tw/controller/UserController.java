package com.tw.controller;

import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tw.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping()
	public String getUsers( @RequestParam(value="page") int page , @RequestParam(value="limit") int limit ,
			@RequestParam(value="sort" , required = false)String sort   )
	{
		return "Getting the users  of page no :" + page + " and limit : " + limit + " sort : "+ sort ;
	}
	
	@GetMapping(path = "/{userid}" , produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE}  ) 
	public ResponseEntity<User> getUser(@PathVariable String userid)	{
		User user1 = new User();
		user1.setLastName("Sayan");
		user1.setLastName("Roy");
		user1.setEmail("sayan44617@gmail.com");
		user1.setPhnNo("xxx-xxx-xxxx");
		return new ResponseEntity<User>(user1, HttpStatus.BAD_REQUEST);
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
