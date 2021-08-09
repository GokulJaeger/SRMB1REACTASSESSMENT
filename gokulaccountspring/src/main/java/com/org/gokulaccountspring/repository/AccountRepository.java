package com.org.gokulaccountspring.repository;

import com.org.gokulaccountspring.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
    
}
