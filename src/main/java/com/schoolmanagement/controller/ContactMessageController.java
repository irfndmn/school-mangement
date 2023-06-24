package com.schoolmanagement.controller;

import com.schoolmanagement.dto.ContactMessageRequest;
import com.schoolmanagement.dto.ContactMessageResponse;
import com.schoolmanagement.entity.ContactMessage;
import com.schoolmanagement.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.domain.Sort.by;

@RestController
@RequestMapping("/contactMessages")
public class ContactMessageController {


    @Autowired
    private ContactMessageService contactMessageService;


    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveMessage(@Valid @RequestBody ContactMessageRequest contactMessageRequest) {

        contactMessageService.saveContactMessage(contactMessageRequest);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Your message has been successfully saved");
        response.put("status", "success");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ContactMessageResponse>> getAll() {

        List<ContactMessageResponse> messages = contactMessageService.getContactMessages();

        return new ResponseEntity<>(messages, HttpStatus.OK);

    }


    @GetMapping("/searchBySubject")
    public ResponseEntity<Page<ContactMessageResponse>> searchContactMessagesBySubject(
            @RequestParam(required = false) String subject,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "sort", required = false) String prop,
            @RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction) {

       Page<ContactMessageResponse> contactMessageResponse= contactMessageService.getContactMessageBySubject(subject,page,size,prop,direction);
        return ResponseEntity.ok(contactMessageResponse);
    }

    @GetMapping("/searchByEmail")
    public ResponseEntity<Page<ContactMessageResponse>> searcContactMessageByEmail(
            @RequestParam(required = false) String email,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "sort", required = false) String prop,
            @RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction) {
        Page<ContactMessageResponse> contactMessageResponse= contactMessageService.getContactMessageByEmail(email,page,size,prop,direction);
        return ResponseEntity.ok(contactMessageResponse);
    }


}
