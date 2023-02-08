package com.example.Admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Admin.model.AdminLoginModel;
import com.example.Admin.repositroy.AdminLoginRepository;
@Service
public class AdminLoginService implements UserDetailsService{

	@Autowired
	public AdminLoginRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AdminLoginModel model= repo.findById(username).get();
		
		return new Adminlogindetails(model);
	}

}
