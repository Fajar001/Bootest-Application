package com.lawencon.bootestApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bootestApplication.dao.CandidateDao;
import com.lawencon.bootestApplication.model.Candidate;
import com.lawencon.bootestApplication.service.CandidateService;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	private CandidateDao dao;

	@Override
	public String createCandidate(Candidate insert) throws Exception {
		if(checkDataExists(insert)==true) {
			return "Data Already Exists";
		}
		dao.createCandidate(insert);
		return "Success insert user candidate";
	}

	@Override
	public List<?> findAll() throws Exception {
		return dao.findAll();
	}

	@Override
	public Candidate findByUsernameCandidate(String username) throws Exception {
		return dao.findByUsernameCandidate(username);
	}

	@Override
	public Candidate findByIdCandidate(String id) throws Exception {
		return dao.findByIdCandidate(id);
	}

	@Override
	public Candidate update(Candidate user) throws Exception {
		return dao.updateCandidate(user);
	}

	@Override
	public String delete(String id) throws Exception {
		if(findByIdCandidate(id)==null) {
			return "No Data Found";
		}
		dao.deleteCandidate(id);
		return "Deleted...";
	}

	@Override
	public boolean checkDataExists(Candidate check) throws Exception {
		Candidate c = null;
		try {
			c = (Candidate) dao.checkDataExists(check);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(c != null) {
			return true;
		}
		return false;
	}
	
	
}
