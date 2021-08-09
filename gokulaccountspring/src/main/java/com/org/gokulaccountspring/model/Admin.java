package com.example.registrationaccount.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Should not be blank")
    @NotNull(message = "Should not be Null")
    @NotEmpty(message = "Should not be Empty")
    private String usename;

    @NotBlank(message = "Should not be blank")
    @NotNull(message = "Should not be Null")
    @NotEmpty(message = "Should not be Empty")
    private String password;

    public Admin() {
    }

    public Admin(long id,
            @NotBlank(message = "Should not be blank") @NotNull(message = "Should not be Null") @NotEmpty(message = "Should not be Empty") String usename,
            @NotBlank(message = "Should not be blank") @NotNull(message = "Should not be Null") @NotEmpty(message = "Should not be Empty") String password) {
        this.id = id;
        this.usename = usename;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
