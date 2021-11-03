package com.lawencon.bootestApplication.service;

import java.util.List;

import com.lawencon.bootestApplication.model.Candidate;

public interface CandidateService {

	String createCandidate(Candidate insert) throws Exception;
	List<?> findAll() throws Exception;
	Candidate findByUsernameCandidate(String username) throws Exception;
	Candidate findByIdCandidate(String id) throws Exception;
	Candidate update(Candidate user) throws Exception;
	String delete(String id) throws Exception;
	boolean checkDataExists(Candidate check)throws Exception;
}
