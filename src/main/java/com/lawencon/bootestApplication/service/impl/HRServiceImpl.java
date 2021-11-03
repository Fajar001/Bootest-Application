package com.lawencon.bootestApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bootestApplication.dao.AdminDao;
import com.lawencon.bootestApplication.dao.HrDao;
import com.lawencon.bootestApplication.dao.ReviewersDao;
import com.lawencon.bootestApplication.model.HR;
import com.lawencon.bootestApplication.service.HRService;

@Service
@Transactional
public class HRServiceImpl implements HRService{

	@Autowired
	private HrDao dao;
	@Autowired
	private AdminDao daoAdmin;
	@Autowired
	private ReviewersDao daoReviewers;
	
	@Override
	public String createHR(HR insert) throws Exception {
		if (checkDataExists(insert) == true) {
			return "Data Already Exists";
		}
		dao.createHr(insert);
		return "Success insert user HR";
	}

	@Override
	public List<?> findAll() throws Exception {
		return dao.findAll();
	}

	@Override
	public HR findByUsernameHR(String username) throws Exception {
		return dao.findByUsernameHR(username);
	}

	@Override
	public HR update(HR user) throws Exception {
		return dao.updateHr(user);
	}

	@Override
	public String delete(String id) throws Exception {
		if(findByIdHR(id)==null) {
			return "No Data Found";
		}
		dao.deleteHr(id);
		return "Deleted...";
	}

	@Override
	public boolean checkDataExists(HR check) throws Exception {
		HR c = null;
		try {
			c = (HR) dao.checkDataExists(check);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(c != null) {
			return true;
		}
		return false;
	}

	@Override
	public HR findByIdHR(String id) throws Exception {
		return dao.findByIdHR(id);
	}

}
