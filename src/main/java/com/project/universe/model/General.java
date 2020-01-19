package com.project.universe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.project.universe.model.dto.GeneralRequestDTO;
import com.project.universe.model.dto.GeneralResponseDTO;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "tabela_teste")
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)

public class General {
	@Id
	@Column(name = "user_id")
	private int userId;
	@Column(name = "username", nullable = true)
	private String username;
	@Column(name = "password", nullable = true)
	private String password;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "created_on", nullable = true)
	private Date createdOn;

	public General(int userId, String username, String password, String email, Date createdOn) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdOn = createdOn;
	}

	public General() {
		super();
	}

	public static General fromDTO(GeneralRequestDTO general) {
		return new General(general.getuserId(), general.getUsername(), general.getPassword(), general.getEmail(),
				general.getcreatedOn());
	}

	public static GeneralResponseDTO toDTO(General general) {
		return new GeneralResponseDTO(general);
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getUserId() {
		return userId;
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

	public Date getCreatedOn() {
		return createdOn;
	}

}