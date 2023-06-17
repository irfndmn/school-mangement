package com.schoolmanagement.domain.concrete;

import com.schoolmanagement.domain.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_Dean")
@NoArgsConstructor
@Getter
@Setter
public class Dean extends User {
}
