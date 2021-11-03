package com.lawencon.bootestApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(indexes = @Index(name = "idx_reviewers", columnList = "username, email"), name = "reviewers")
public class Reviewers {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String idReviewers;
	private String username;
	private String email;
	private String password;
	
	public Reviewers() {}

	public String getIdReviewers() {
		return idReviewers;
	}

	public void setIdReviewers(String idReviewers) {
		this.idReviewers = idReviewers;
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

	public Reviewers(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
