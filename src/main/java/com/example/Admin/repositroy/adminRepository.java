package com.example.Admin.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Admin.model.AdminModel;

public interface adminRepository extends JpaRepository<AdminModel, String > {

}
