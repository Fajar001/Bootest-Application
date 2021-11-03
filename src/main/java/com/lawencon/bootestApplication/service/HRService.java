package com.lawencon.bootestApplication.service;

import java.util.List;

import com.lawencon.bootestApplication.model.HR;

public interface HRService {

	String createHR(HR insert) throws Exception;
	List<?> findAll() throws Exception;
	HR findByUsernameHR(String username) throws Exception;
	HR findByIdHR(String id) throws Exception;
	HR update(HR user) throws Exception;
	String delete(String id) throws Exception;
	boolean checkDataExists(HR check)throws Exception;
}
