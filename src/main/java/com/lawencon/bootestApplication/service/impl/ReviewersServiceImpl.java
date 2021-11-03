package com.lawencon.bootestApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bootestApplication.dao.ReviewersDao;
import com.lawencon.bootestApplication.model.Reviewers;
import com.lawencon.bootestApplication.service.ReviewersService;

@Service
@Transactional
public class ReviewersServiceImpl implements ReviewersService{

	@Autowired
	private ReviewersDao dao;

	@Override
	public String createReviewers(Reviewers insert) throws Exception {
		if (checkDataExists(insert) == true) {
			return "Data Already Exists";
		}
		dao.createReviewers(insert);
		return "Success insert user admin";
	}

	@Override
	public List<?> findAll() throws Exception {
		return dao.findAll();
	}

	@Override
	public Reviewers findByUsernameReviewers(String username) throws Exception {
		return dao.findByUsernameReviewers(username);
	}

	@Override
	public Reviewers update(Reviewers user) throws Exception {
		return dao.updateReviewers(user);
	}

	@Override
	public String delete(String id) throws Exception {
		// TODO Auto-generated method stub
		if(findByIdReviewers(id)==null) {
			return "No Data Found";
		}
		dao.deleteReviewers(id);
		return "Deleted...";
	}

	@Override
	public boolean checkDataExists(Reviewers check) throws Exception {
		Reviewers c = null;
		try {
			c = (Reviewers) dao.checkDataExists(check);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(c != null) {
			return true;
		}
		return false;
	}

	@Override
	public Reviewers findByIdReviewers(String username) throws Exception {
		return dao.findByIdReviewers(username);
	}
}
