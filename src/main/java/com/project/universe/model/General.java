package com.project.universe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.universe.model.dto.GeneralRequestDTO;
import com.project.universe.model.dto.GeneralResponseDTO;


@Entity
@Table(name = "tabela_teste")
public class General {
	@Id
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "username", nullable = true)
	private String username;
	@Column(name = "password", nullable = true)
	private String password;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "created_on", nullable = true)
	private Date created_on;

	public General(int user_id, String username, String password, String email, Date created_on) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.created_on = created_on;
	}

	public General() {
		super();
	}

	public static General fromDTO(GeneralRequestDTO general) {
		return new General(general.getUser_id(), general.getUsername(), general.getPassword(), general.getEmail(),
				general.getCreated_on());
	}

	public static GeneralResponseDTO toDTO(General general) {
		return new GeneralResponseDTO(general);
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

	public Date getCreatedOn() {
		return created_on;
	}

	public void setCreatedOn(Date created_on) {
		this.created_on = created_on;
	}

}