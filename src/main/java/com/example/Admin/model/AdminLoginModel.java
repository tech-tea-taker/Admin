package com.example.Admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="login")
public class AdminLoginModel {
    
	@Id
	private String email;
	@Column(name="password")
	private String password;
	
	
	public AdminLoginModel() {
		super();
	}
	
	
	public AdminLoginModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		
		
		this.password =password ;
	}
	
}
