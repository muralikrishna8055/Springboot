package com.basic.app.Springboot.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
    //, schema = "userManagement" is used as a parameter in @Table to distinguish when we have multiple table with same name

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="USER_NAME",nullable = false,unique = true)
    private String username;

    @Column(name="FIRST_NAME",nullable = false,unique = true)
    private String firstname;

    @Column(name = "LAST_NAME",nullable = false,unique = true)
    private String lastname;

    @Column(name = "EMAIL",nullable = false,unique = true)
    private  String email;

    @Column(name = "ROLE",nullable = false,unique = true)
    private  String role;

    @Column(name = "SSN", nullable = false,unique = true)
    private String ssn;


}
