package com.schoolmanagement.service;

import com.schoolmanagement.dto.ContactMessageRequest;
import com.schoolmanagement.dto.ContactMessageResponse;
import com.schoolmanagement.entity.ContactMessage;
import com.schoolmanagement.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactMessageService {
    @Autowired
    private ContactMessageRepository contactMessageRepository;



    public void saveContactMessage(ContactMessageRequest contactMessageRequest) {

        ContactMessage contactMessage = new ContactMessage(contactMessageRequest);

        contactMessageRepository.save(contactMessage);

    }



    public List<ContactMessageResponse> getContactMessages() {

        List<ContactMessage> contactMessagesList = contactMessageRepository.findAll();

        return contactMessagesList.stream().map(ContactMessageResponse::new).collect(Collectors.toList());

    }




    public Page<ContactMessageResponse> getContactMessageBySubject(String subject, int page, int size, String prop, Sort.Direction direction) {

        Pageable pageable= PageRequest.of(page,size,Sort.by(direction,prop));

        return contactMessageRepository.findAllBySubject(subject,pageable).map(ContactMessageResponse::new);
    }


    public Page<ContactMessageResponse> getContactMessageByEmail(String email, int page, int size, String prop, Sort.Direction direction) {

        Pageable pageable= PageRequest.of(page,size,Sort.by(direction,prop));

        return contactMessageRepository.findAllByEmail(email,pageable).map(ContactMessageResponse::new);
    }


}
