package com.lawencon.bootestApplication.service;

import java.util.List;

import com.lawencon.bootestApplication.model.Admin;

public interface AdminService {

	String createAdmin(Admin insert) throws Exception;
	List<?> findAll() throws Exception;
	Admin findByUsernameAdmin(String username) throws Exception;
	Admin update(Admin user) throws Exception;
	String delete(String username) throws Exception;
	boolean checkDataExists(Admin check)throws Exception;
//	boolean checkDataValid(Admin check)throws Exception;
}
