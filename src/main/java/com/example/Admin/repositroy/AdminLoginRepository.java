package com.example.Admin.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Admin.model.AdminLoginModel;

public interface AdminLoginRepository extends JpaRepository<AdminLoginModel, String>{

}
