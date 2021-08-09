package com.example.registrationaccount.repository;

import com.example.registrationaccount.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
