package com.lawencon.bootestApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.bootestApplication.model.Admin;
import com.lawencon.bootestApplication.model.HR;
import com.lawencon.bootestApplication.model.Reviewers;
import com.lawencon.bootestApplication.service.AdminService;
import com.lawencon.bootestApplication.service.HRService;
import com.lawencon.bootestApplication.service.ReviewersService;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController{

	@Autowired
	private AdminService as;
	@Autowired
	private HRService hs;
	@Autowired
	private ReviewersService rs;
	
//	Scope CRUD Admin
	@GetMapping("/list")
	public ResponseEntity<?> getListAdmin(){
		List<?> listAdmin = new ArrayList<>();
		try {
			listAdmin = as.findAll();
			return new ResponseEntity<>(listAdmin, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listAdmin, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> getInsert(@RequestBody String content){
		try {
			Admin in = readValue(content, Admin.class);
			return new ResponseEntity<>(as.createAdmin(in), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> getUpdate(@RequestBody String content){
		try {
			Admin up = readValue(content, Admin.class);
			return new ResponseEntity<>(as.update(up), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{userAdmin}")
	public ResponseEntity<?> getDelete(@PathVariable("userAdmin") String userAdmin){
		try {
			return new ResponseEntity<>(as.delete(userAdmin), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/search/{userAdmin}")
	public ResponseEntity<?> getUsername(@PathVariable("userAdmin") String userAdmin){
		try {
			return new ResponseEntity<>(as.findByUsernameAdmin(userAdmin), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
//	Scope CRUD HR by ADMIN
	@GetMapping("/HR/list")
	public ResponseEntity<?> getListHR(){
		List<?> listHR = new ArrayList<>();
		try {
			listHR = hs.findAll();
			return new ResponseEntity<>(listHR, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listHR, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/HR/create")
	public ResponseEntity<?> getInsertHR(@RequestBody String content){
		try {
			HR in = readValue(content, HR.class);
			return new ResponseEntity<>(hs.createHR(in), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/HR/update")
	public ResponseEntity<?> getUpdateHR(@RequestBody String content){
		try {
			HR up = readValue(content, HR.class);
			return new ResponseEntity<>(hs.update(up), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/HR/delete/{userHR}")
	public ResponseEntity<?> getDeleteHR(@PathVariable("userHR") String userHR){
		try {
			return new ResponseEntity<>(hs.delete(userHR), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/HR/search/{userHR}")
	public ResponseEntity<?> getUsernameHR(@PathVariable("userHR") String userHR){
		try {
			return new ResponseEntity<>(hs.findByUsernameHR(userHR), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
//	Scope CRUD Reviewers by Admin
	@GetMapping("/Rev/list")
	public ResponseEntity<?> getListReviewers(){
		List<?> listHR = new ArrayList<>();
		try {
			listHR = rs.findAll();
			return new ResponseEntity<>(listHR, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listHR, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/Rev/create")
	public ResponseEntity<?> getInsertReviewers(@RequestBody String content){
		try {
			Reviewers in = readValue(content, Reviewers.class);
			return new ResponseEntity<>(rs.createReviewers(in), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/Rev/update")
	public ResponseEntity<?> getUpdateReviewers(@RequestBody String content){
		try {
			Reviewers up = readValue(content, Reviewers.class);
			return new ResponseEntity<>(rs.update(up), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/Rev/delete/{userReviewers}")
	public ResponseEntity<?> getDeleteReviewers(@PathVariable("userReviewers") String userReviewers){
		try {
//			as.delete(userAdmin);
			return new ResponseEntity<>(rs.delete(userReviewers), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/Rev/search/{userReviewers}")
	public ResponseEntity<?> getUsernameReviewers(@PathVariable("userReviewers") String userReviewers){
		try {
			return new ResponseEntity<>(rs.findByUsernameReviewers(userReviewers), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
