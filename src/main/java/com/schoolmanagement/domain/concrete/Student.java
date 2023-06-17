package com.schoolmanagement.domain.concrete;
import com.schoolmanagement.domain.abstracts.User;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)   // biz olusturtabiliriz
    private int studentNumber;


    @Column(unique = true)
    private String email;

    private boolean isActive;


}
