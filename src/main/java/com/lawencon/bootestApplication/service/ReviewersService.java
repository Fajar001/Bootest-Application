package com.lawencon.bootestApplication.service;

import java.util.List;

import com.lawencon.bootestApplication.model.Reviewers;

public interface ReviewersService {

	String createReviewers(Reviewers insert) throws Exception;
	List<?> findAll() throws Exception;
	Reviewers findByUsernameReviewers(String username) throws Exception;
	Reviewers findByIdReviewers(String id) throws Exception;
	Reviewers update(Reviewers user) throws Exception;
	String delete(String id) throws Exception;
	boolean checkDataExists(Reviewers check)throws Exception;
}
