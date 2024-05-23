package com.tw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.tw.model.UserDetails;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping()
	public String getUsers( @RequestParam(value="page") int page , @RequestParam(value="limit") int limit ,
			@RequestParam(value="sort" , required = false)String sort   )
	{
		return "Getting the users  of page no :" + page + " and limit : " + limit + " sort : "+ sort ;
	}
	
	@GetMapping(path = "/{userid}" , produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}  ) 
	public ResponseEntity<UserDetails> getUser(@PathVariable String userid)	{
		UserDetails user1 = new UserDetails();
		user1.setLastName("Sayan");
		user1.setLastName("Roy");
		user1.setEmail("sayan44617@gmail.com");
		user1.setPhnNo("xxx-xxx-xxxx");
		return new ResponseEntity<UserDetails>(user1, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@PostMapping
	public ResponseEntity<UserDetails> addUser(@Valid  @RequestBody UserDetails userdetails)
	{
		UserDetails user1 = new UserDetails();
		user1.setFirstName(userdetails.getFirstName());
		user1.setLastName(userdetails.getLastName());
		user1.setEmail(userdetails.getEmail());
		user1.setPhnNo(userdetails.getPhnNo());
		
		return new ResponseEntity<UserDetails>(user1 , HttpStatus.OK);
		
	}
	
	@PutMapping
	public String updateUser()
	{
		return "Updated a user " ;
	}
	
	@DeleteMapping
	public String DeleteUser()
	{
		return "Deleted a user";
	}

}
