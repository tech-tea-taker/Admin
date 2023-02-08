package com.example.Admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminuser")
public class AdminModel {

	@Id
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="phone_no")
	private long phone_no;
	
	
	
	public AdminModel() {
		super();
	}
	
	public AdminModel(String id, String name, String email, long phone_no) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone_no = phone_no;
	}
	
	@Override
	public String toString() {
		return "AdminModel [id=" + id + ", name=" + name + ", email=" + email + ", phone_no=" + phone_no + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	
	
	
}
