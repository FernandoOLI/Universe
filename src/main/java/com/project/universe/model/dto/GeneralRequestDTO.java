package com.project.universe.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GeneralRequestDTO {

	private int user_id;
	private String username;
	private String password;
	private String email;
	private Date created_on;

	@JsonCreator
	public GeneralRequestDTO(@JsonProperty("user_id") int user_id, @JsonProperty("username") String username,
			@JsonProperty("password") String password, @JsonProperty("email") String email,
			@JsonProperty("created_on") Date created_on) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.created_on = created_on;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

}
