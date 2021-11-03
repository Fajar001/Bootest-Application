package com.lawencon.bootestApplication.dao;

import java.util.List;

import com.lawencon.bootestApplication.model.Candidate;

public interface CandidateDao {

	void createCandidate(Candidate create) throws Exception;
	Candidate updateCandidate(Candidate user) throws Exception;
	List<?> findAll() throws Exception;
	Candidate findByUsernameCandidate(String username) throws Exception;
	Candidate findByIdCandidate(String id) throws Exception;
	Candidate checkDataExists(Candidate check) throws Exception;
	void deleteCandidate(String username) throws Exception;
}
