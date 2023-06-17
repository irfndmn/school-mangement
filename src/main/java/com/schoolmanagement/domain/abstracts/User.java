package com.schoolmanagement.domain.abstracts;

import com.schoolmanagement.domain.enums.Gender;
import com.schoolmanagement.domain.enums.userRole;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String ssn;

    private String name;

    private String surname;

    private LocalDate birtDay;

    private String birtPlace;

    private String password;

    private userRole userRole;

    @Column(unique = true)
    private String phoneNumber;

    private Gender gender;


}
