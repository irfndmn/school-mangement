package com.schoolmanagement.dto;
import com.schoolmanagement.entity.ContactMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessageResponse {

    private String name;
    private String email;
    private String subject;
    private String message;

    public ContactMessageResponse(ContactMessage contactMessage) {

        this.message=contactMessage.getMessage();
        this.email=contactMessage.getEmail();
        this.name=contactMessage.getName();
        this.subject=contactMessage.getSubject();
    }


}