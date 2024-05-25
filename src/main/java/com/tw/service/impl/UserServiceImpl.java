package com.tw.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.model.request.UserDetailsRequest;
import com.tw.model.response.UserDetails;
import com.tw.service.UserService;
import com.tw.shared.Utils;

@Service
public class UserServiceImpl implements UserService{
	
	Map<String , UserDetails> users;
	Utils utils ;
	


	public UserServiceImpl() {
		super();
	}



	@Autowired
	public UserServiceImpl(Utils utils) {
		super();
		this.utils = utils;
	}




	@Override
	public UserDetails createUser(UserDetailsRequest userDetailsRequest) {
		// TODO Auto-generated method stub
		String id = utils.generateUserId();
		UserDetails returnValue = new UserDetails();
		returnValue.setLastName(userDetailsRequest.getLastName());
		returnValue.setFirstName(userDetailsRequest.getFirstName());
		returnValue.setEmail(userDetailsRequest.getEmail());
		returnValue.setPhnNo(userDetailsRequest.getPhnNo());
		returnValue.setId(id);
		
		if(users==null) users = new HashMap<>();
		users.put(id, returnValue);
		return returnValue;
	}

}
