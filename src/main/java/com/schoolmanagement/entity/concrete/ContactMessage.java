package com.schoolmanagement.entity.concrete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @Email
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    private String subject;

    private String message;

    private LocalDate date=formattedType(LocalDate.now());  // LocalDate normalde


    public LocalDate formattedType(LocalDate localDate){

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDate.parse(dtf.format(localDate));
    }


}
