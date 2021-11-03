package com.lawencon.bootestApplication.dao;

import java.util.List;

import com.lawencon.bootestApplication.model.Admin;

public interface AdminDao {
	void createAdmin(Admin insert) throws Exception;
	List<?> findAll() throws Exception;
	Admin findByUsernameAdmin(String username) throws Exception;
	Admin update(Admin user) throws Exception;
	Admin checkDataExists(Admin check) throws Exception;
	Admin checkDataValid(Admin check) throws Exception;
	void delete(String username) throws Exception;
}
