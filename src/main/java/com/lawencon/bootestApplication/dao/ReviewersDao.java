package com.lawencon.bootestApplication.dao;

import java.util.List;

import com.lawencon.bootestApplication.model.Reviewers;

public interface ReviewersDao {

	void createReviewers(Reviewers create) throws Exception;
	Reviewers updateReviewers(Reviewers update) throws Exception;
	List<?> findAll() throws Exception;
	Reviewers findByUsername(String username) throws Exception;
	Reviewers checkDataExists(Reviewers check) throws Exception;
	void deleteReviewers(String username) throws Exception;
}
