package com.lawencon.bootestApplication.dao;

import java.util.List;

import com.lawencon.bootestApplication.model.HR;

public interface HrDao {

	void createHr(HR create) throws Exception;
	HR updateHr(HR user) throws Exception;
	List<?> findAll() throws Exception;
	HR findByUsernameHR(String username) throws Exception;
	HR findByIdHR(String id) throws Exception;
	HR checkDataExists(HR check) throws Exception;
	void deleteHr(String username) throws Exception;
}
