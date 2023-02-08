package com.example.Admin.controller;

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

import com.example.Admin.model.AdminModel;
import com.example.Admin.service.service;


@RestController
@RequestMapping("/admin/details")
public class controller {
	
	@Autowired
	public service serve;

	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<AdminModel>> getallAdmin(){
		List<AdminModel> admin=serve.getallEmp();
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
	@PostMapping("/addAdmin")
	public ResponseEntity<AdminModel> addAdmin(@RequestBody AdminModel model){
		AdminModel admin=serve.addEmployee(model);
		return new ResponseEntity<>(admin,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<AdminModel> updateAdmin(@RequestBody AdminModel model ,@PathVariable("id") String id){
		AdminModel admin=serve.updateEmp(model,id);
		return new ResponseEntity<>(admin, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<String> DeleteAdmin(@PathVariable("id") String id){
		serve.deleteEmp(id);
		return  ResponseEntity.ok ("Successfully data deleted.");
	}
	
	@GetMapping("/findAdmin/{id}")
	public ResponseEntity<AdminModel> findAdmins(@PathVariable("id")  String id){
		AdminModel adm=serve.findAdmin(id);
		if(adm != null) {
			return new ResponseEntity<>(adm ,HttpStatus.OK);

		}else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
