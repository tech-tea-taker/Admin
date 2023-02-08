package com.example.Admin.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Admin.model.AdminModel;
import com.example.Admin.repositroy.adminRepository;

@Service
public class service {
	
	@Autowired
	public adminRepository adminrepo;
	

	public List<AdminModel> getallEmp() {
		return adminrepo.findAll();
	}
	
	public AdminModel updateEmp(AdminModel model, String id) {
				
		model.setId(id);
		
		return adminrepo.save(model);
	}
	
	public void deleteEmp(String id) {
		adminrepo.deleteById(id);
	}
	
	public AdminModel addEmployee(AdminModel model) {
		model.setId(UUID.randomUUID().toString());
		return adminrepo.save(model);
	}
	
	public AdminModel findAdmin(String id) {
		try {
			return	adminrepo.findById(id).get();
		}catch(Exception e) {
			return null;
					
		}
	
	}
}
