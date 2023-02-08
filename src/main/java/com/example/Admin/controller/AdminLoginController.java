package com.example.Admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Admin.model.AdminLoginModel;
import com.example.Admin.service.Loginservice;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin/auth")
public class AdminLoginController {
	
	@Autowired
	public Loginservice service;

	@PostMapping("/registration")
	public ResponseEntity<String> getRegistration(@RequestBody AdminLoginModel model){
		
		String message= service.Registration(model);
		
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> getAuthenticate(@RequestBody AdminLoginModel model){
		
		String token= service.Authentication(model);
		
		return new ResponseEntity<>(token, HttpStatus.OK);
	}
	
	
	@GetMapping("/validtoken/{token}")
	public Boolean gettokenvalidation(@PathVariable("token") String token) {
		
		return service.validToken(token);
	}
	
}
