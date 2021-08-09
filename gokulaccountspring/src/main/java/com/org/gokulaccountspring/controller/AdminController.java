package com.example.registrationaccount.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.example.registrationaccount.exception.ResourceNotFoundException;
import com.example.registrationaccount.model.Admin;
import com.example.registrationaccount.repository.AdminRepository;

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
public class AdminController {

    private Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminRepository adminrepo;

    @GetMapping("/admin")
    public List<Admin> getAllAdmins() {
        log.info("Admin Data's fetched: ");
        return adminrepo.findAll();
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Admin> getAdminById(@Valid @PathVariable(value = "id") Long adminLong)
            throws ResourceNotFoundException {
        Admin admin1 = adminrepo.findById(adminLong)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminLong));
        log.info("Admin Data's fetched: ");
        return ResponseEntity.ok().body(admin1);
    }

    @PostMapping("/admin")
    public Admin createAdmin(@Valid @RequestBody Admin admin2) throws ResourceNotFoundException {
        log.info("Admin Inserted!...");
        return adminrepo.save(admin2);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Admin> updateAdmin(@Valid @PathVariable(value = "id") Long adminLong,
            @Valid @RequestBody Admin adminDetails) throws ResourceNotFoundException {
        Admin admin = adminrepo.findById(adminLong)
                .orElseThrow(() -> new ResourceNotFoundException("Admin cannot be found for this id :: " + adminLong));
        admin.setUsename(adminDetails.getUsename());
        admin.setPassword(adminDetails.getPassword());
        final Admin updatedAdmin = adminrepo.save(admin);
        log.info("Admin Updated!...");
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/admin/{id}")
    public Map<String, Boolean> deleteAdmin(@Valid @PathVariable(value = "id") Long adminLong)
            throws ResourceNotFoundException {
        Admin admin = adminrepo.findById(adminLong)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminLong));

        adminrepo.delete(admin);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Admin Deleted", Boolean.TRUE);
        log.info("Admin Deleted!....");
        return response;
    }
}
