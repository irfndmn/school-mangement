package com.schoolmanagement.service;

import com.schoolmanagement.dto.ContactMessageDTO;
import com.schoolmanagement.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {
    @Autowired
    private ContactMessageRepository contactMessageRepository;
    public void saveContactMessage(ContactMessageDTO contactMessageDTO) {

    }
}
