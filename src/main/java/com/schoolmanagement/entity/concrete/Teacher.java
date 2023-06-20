package com.schoolmanagement.entity.concrete;

import com.schoolmanagement.entity.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_teacher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher extends User {
    private boolean isAdvisor;

    @Email
    @Column(unique = true)
    @NotNull
    private String email;

}
