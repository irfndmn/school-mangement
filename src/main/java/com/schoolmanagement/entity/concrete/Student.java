package com.schoolmanagement.entity.concrete;

import com.schoolmanagement.entity.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;


@Entity
@Table(name = "t_student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student extends User {

    private String motherName;

    private String fatherName;


    @GeneratedValue(generator = "sequencegen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequencegen",
            sequenceName = "student_seq",
            initialValue = 2023,
            allocationSize = 3)
    private int studentNumber;


    @Column(unique = true)
    private String email;

    private boolean isActive;


}
