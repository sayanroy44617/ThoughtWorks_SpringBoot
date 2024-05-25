package com.tw.service;

import com.tw.model.request.UserDetailsRequest;
import com.tw.model.response.UserDetails;

public interface UserService {

	public UserDetails createUser(UserDetailsRequest userDetailsRequest);
}
