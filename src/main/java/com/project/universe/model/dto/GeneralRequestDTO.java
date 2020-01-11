package com.project.universe.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GeneralRequestDTO {

	private int userId;
	private String username;
	private String password;
	private String email;
	private Date createdOn;

	@JsonCreator
	public GeneralRequestDTO(@JsonProperty("userId") int userId, @JsonProperty("username") String username,
			@JsonProperty("password") String password, @JsonProperty("email") String email,
			@JsonProperty("createdOn") Date createdOn) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdOn = createdOn;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getcreatedOn() {
		return createdOn;
	}

	public void setcreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
