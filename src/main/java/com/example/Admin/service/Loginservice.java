package com.example.Admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.Admin.jwt.Utils;
import com.example.Admin.model.AdminLoginModel;
import com.example.Admin.repositroy.AdminLoginRepository;
import com.example.Admin.security.AdminLoginService;
import com.example.Admin.security.Adminlogindetails;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class Loginservice {

	@Autowired
	public AuthenticationManager authmanager;

	
	@Autowired
	public AdminLoginRepository adminloginrepository;
	
	
	@Autowired
	public Utils util;
	
	@Autowired
	public AdminLoginService loginservice;
	
	
	public String Registration(AdminLoginModel model) {
		if(adminloginrepository.findById(model.getEmail()).isEmpty()) {
		try {
			BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
			String encodePassword=encoder.encode(model.getPassword());
			model.setPassword(encodePassword);
			adminloginrepository.save(model);
			
			return "Admin Added Successfully";
			
		}catch(Exception e){
			
			return e.getMessage();
		}
		}else {
			return "email already in use";
		}
		
	}
	
	public String Authentication(AdminLoginModel model) {
		try {
			
			org.springframework.security.core.Authentication auth= authmanager
					.authenticate
					(new UsernamePasswordAuthenticationToken
							(model.getEmail(), 
									model.getPassword()));
			
			if(auth.isAuthenticated()) {
				Adminlogindetails details= new Adminlogindetails(model); 
				String token =util.generateToken(details);
				
				return token;
			}
			return "return user not authenticated";
			
			
		}catch(Exception e) {

			if(adminloginrepository.findById(model.getEmail()).isPresent()) {
				AdminLoginModel mdl=adminloginrepository.findById(model.getEmail()).get();
				
				if(!mdl.getPassword().equals(model.getPassword())) {
					return "email or password does not match";
				}
			}
			return "there is an error";
		
		}
	}
	
	
	public Boolean validToken(String token) {
		try {
		String username=util.getAdminUsername(token);
		
		Adminlogindetails details= (Adminlogindetails) loginservice.loadUserByUsername(username);
		
		return util.validateToken(token, details);
		
		}catch(Exception e) {
			return false;
		}
	}
	
}
