package com.schoolmanagement.domain.concrete;

import com.schoolmanagement.domain.abstracts.User;
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
