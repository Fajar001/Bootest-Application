package com.lawencon.bootestApplication.service;

import java.util.List;

import com.lawencon.bootestApplication.model.Admin;

public interface AdminService {

	String createAdmin(Admin insert) throws Exception;
	List<?> findAll() throws Exception;
	Admin findByUsernameAdmin(String username) throws Exception;
	Admin findByIdAdmin(String id) throws Exception;
	Admin update(Admin user) throws Exception;
	String delete(String id) throws Exception;
	boolean checkDataExists(Admin check)throws Exception;
}
