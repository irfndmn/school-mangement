package com.schoolmanagement.domain.abstracts;

import com.schoolmanagement.domain.enums.Gender;
import com.schoolmanagement.domain.enums.userRole;
import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass                   // Bu super classta mevcut olan fieledlari hata almadan inherit edip subclasslarin bu fieldlari kullanarak tablo olusturmalarina yardimci olur
public abstract class User {   // Developerlar yanlislikla constructor olusturmasin diye abstract yaptim
                               // cunku user diye bir rol yok sadece ortak data icin kullandim


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
