package com.lawencon.bootestApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bootestApplication.dao.AdminDao;
import com.lawencon.bootestApplication.model.Admin;
import com.lawencon.bootestApplication.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;

	@Override
	public String createAdmin(Admin insert) throws Exception {
		if (checkDataExists(insert) == true) {
			return "Data Already Exists";
		}
		dao.createAdmin(insert);
		return "Success insert user admin";
	}

	@Override
	public List<?> findAll() throws Exception {
		return dao.findAll();
	}

	@Override
	public Admin findByUsernameAdmin(String username) throws Exception {
		return dao.findByUsernameAdmin(username);
	}

	@Override
	public Admin update(Admin user) throws Exception {
		return dao.update(user);
	}

	@Override
	public String delete(String id) throws Exception {
		if(findByIdAdmin(id)==null) {
			return "No data found";
		}
		dao.delete(id);
		return "Deleted...";
	}

	@Override
	public boolean checkDataExists(Admin check) throws Exception {
		Admin c = null;
		try {
			c = (Admin) dao.checkDataExists(check);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (c != null) {
			return true;
		}
		return false;
	}

	@Override
	public Admin findByIdAdmin(String id) throws Exception {
		return dao.findByIdAdmin(id);
	}
	
}
