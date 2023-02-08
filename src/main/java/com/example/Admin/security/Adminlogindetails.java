package com.example.Admin.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.example.Admin.model.AdminLoginModel;

@Component
public class Adminlogindetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AdminLoginModel loginmodel;
	
	public Adminlogindetails(AdminLoginModel loginmodel) {
		this.loginmodel=loginmodel;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("Admin"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return loginmodel.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return loginmodel.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
	
	
	
}
