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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.bootestApplication.model.Admin;
import com.lawencon.bootestApplication.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController{

	@Autowired
	private AdminService as;
	
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
			Admin in = new ObjectMapper().readValue(content, Admin.class);
			return new ResponseEntity<>(as.createAdmin(in), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> getUpdate(@RequestBody String content){
		try {
			Admin up = new ObjectMapper().readValue(content, Admin.class);
			return new ResponseEntity<>(as.update(up), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{userAdmin}")
	public ResponseEntity<?> getDelete(@PathVariable("userAdmin") String userAdmin){
		try {
//			as.delete(userAdmin);
			return new ResponseEntity<>(as.delete(userAdmin), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/search/{userAdmin}")
	public ResponseEntity<?> getId(@PathVariable("userAdmin") String userAdmin){
		try {
			return new ResponseEntity<>(as.findByUsernameAdmin(userAdmin), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
