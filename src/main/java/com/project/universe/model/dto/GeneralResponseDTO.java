package com.project.universe.model.dto;

import java.util.Date;

import com.project.universe.model.General;

/** Data Transfer Object (DTO) representing Example responses. */
public class GeneralResponseDTO {

	private int user_id;
	private String username;
	private String password;
	private String email;
	private Date created_on;

	public GeneralResponseDTO(General general) {
		this.user_id = getUser_id();
		this.username = getUsername();
		this.password = getPassword();
		this.email = getEmail();
		this.created_on = getCreated_on();
	}

	public int getUser_id() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Date getCreated_on() {
		return created_on;
	}

}
