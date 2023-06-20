package com.schoolmanagement.entity.concrete;

import com.schoolmanagement.entity.abstracts.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_admin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Admin extends User {
    private boolean built_in;

}
