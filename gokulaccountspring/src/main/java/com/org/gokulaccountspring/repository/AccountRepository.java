package com.example.registrationaccount.repository;

import com.example.registrationaccount.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
    
}
