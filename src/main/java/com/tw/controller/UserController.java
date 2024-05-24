package com.tw.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

import com.tw.model.UpdateUserDetailsRequestModel;
import com.tw.model.UserDetails;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Map<String , UserDetails> users = new HashMap<>();

	@GetMapping()
	public String getUsers( @RequestParam(value="page") int page , @RequestParam(value="limit") int limit ,
			@RequestParam(value="sort" , required = false)String sort   )
	{
		return "Getting the users  of page no :" + page + " and limit : " + limit + " sort : "+ sort ;
	}
	
	@GetMapping(path = "/{userid}" , produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}  ) 
	public ResponseEntity<UserDetails> getUser(@PathVariable String userid)	{
		
		if(users.containsKey(userid))
		{
			return new ResponseEntity<UserDetails>(users.get(userid), HttpStatus.OK);
		}
		else
		{	
			return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
		}
	
	}
	
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDetails> addUser(@Valid  @RequestBody UserDetails userdetails)
	{
		String id = UUID.randomUUID().toString();
		UserDetails user1 = new UserDetails();
		user1.setFirstName(userdetails.getFirstName());
		user1.setLastName(userdetails.getLastName());
		user1.setEmail(userdetails.getEmail());
		user1.setPhnNo(userdetails.getPhnNo());
		user1.setId(id);
		users.put(id, user1);
		
		return new ResponseEntity<UserDetails>(user1 , HttpStatus.OK);
		
	}
	
	
	@PutMapping(path="/{userid}" , consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE} )
	public UserDetails updateUser(@PathVariable String userid , @RequestBody UpdateUserDetailsRequestModel updateUserDetails)
	{
		UserDetails user = users.get(userid);
		user.setFirstName(updateUserDetails.getFirstName());
		user.setLastName(updateUserDetails.getLastName());
		users.put(userid, user);
		
		return user ;
	}
	
	@DeleteMapping(path= "/{userid}")
	public ResponseEntity<Void> DeleteUser(@PathVariable String userid)
	{
		users.remove(userid);
		return ResponseEntity.noContent().build();
	}

}
