package com.tw.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetails {
	
	private String id ;

	@NotNull(message = "FirstName can't be null")
	private String firstName;
	@NotNull
	private String lastName;
	@Email(message = "Give proper email")
	private String email;
	@NotNull
	@Size(max = 10 , min = 10)
	private String phnNo;

	public String getFirstName() {
		return firstName;
	}
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnNo() {
		return phnNo;
	}

	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}

}
