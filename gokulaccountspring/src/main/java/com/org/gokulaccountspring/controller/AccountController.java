package com.org.gokulaccountspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.org.gokulaccountspring.exception.ResourceNotFoundException;
import com.org.gokulaccountspring.model.Account;
import com.org.gokulaccountspring.repository.AccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AccountController {

    private Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AccountRepository accountrepo;

    @GetMapping("/account")
    public List<Account> getAllAccounts() {
        log.info("Admin Data's fetched: ");
        return accountrepo.findAll();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountById(@Valid @PathVariable(value = "id") Long accLong)
            throws ResourceNotFoundException {
        Account acc1 = accountrepo.findById(accLong)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + accLong));
        log.info("Admin Data's fetched: ");
        return ResponseEntity.ok().body(acc1);
    }

    @PostMapping("/account")
    public Account createAdmin(@Valid @RequestBody Account acc2) throws ResourceNotFoundException {
        log.info("Admin Inserted!...");
        return accountrepo.save(acc2);
    }

    @PutMapping("/account/{id}")
    public ResponseEntity<Account> updateAccount(@Valid @PathVariable(value = "id") Long accLong,
            @Valid @RequestBody Account accDetails) throws ResourceNotFoundException {
        Account acc3 = accountrepo.findById(accLong)
                .orElseThrow(() -> new ResourceNotFoundException("Admin cannot be found for this id :: " + accLong));

        accDetails.setFirstname(acc3.getFirstname());
        accDetails.setLastname(acc3.getLastname());
        accDetails.setAge(acc3.getAge());
        accDetails.setEmail(acc3.getEmail());
        accDetails.setPassword(acc3.getPassword());
        accDetails.setPhonenumber(acc3.getPhonenumber());
        accDetails.setUsername(acc3.getUsername());
        final Account updatedAdmin = accountrepo.save(acc3);
        log.info("Admin Updated!...");
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/account/{id}")
    public Map<String, Boolean> deleteAccount(@Valid @PathVariable(value = "id") Long accLong)
            throws ResourceNotFoundException {
        Account acc4 = accountrepo.findById(accLong)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + accLong));

        accountrepo.delete(acc4);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Admin Deleted", Boolean.TRUE);
        log.info("Admin Deleted!....");
        return response;
    }
}
