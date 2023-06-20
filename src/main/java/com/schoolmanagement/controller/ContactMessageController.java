package com.schoolmanagement.controller;


import com.schoolmanagement.dto.ContactMessageDTO;
import com.schoolmanagement.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/contactMessages")
public class ContactMessageController {


    @Autowired
    private ContactMessageService contactMessageService;


    @PostMapping("/save")
    private ResponseEntity<Map<String,String>> saveMessage(@Valid @RequestBody ContactMessageDTO contactMessageDTO){

        contactMessageService.saveContactMessage(contactMessageDTO);

        Map<String,String> response=new HashMap<>();
        response.put("message","Your message has been successfully saved");
        response.put("status","success");


        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}
