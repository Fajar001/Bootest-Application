package com.lawencon.bootestApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(indexes = @Index(name = "idx_candidate", columnList = "username, email"), name = "candidate")
public class Candidate {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String idCandidate;
	private String username;
	private String email;
	private String password;

	public String getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(String idCandidate) {
		this.idCandidate = idCandidate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
