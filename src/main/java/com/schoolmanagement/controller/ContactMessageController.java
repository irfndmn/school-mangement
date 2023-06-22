package com.schoolmanagement.controller;
import com.schoolmanagement.dto.ContactMessageRequest;
import com.schoolmanagement.dto.ContactMessageResponse;
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
    public ResponseEntity<Map<String,String>> saveMessage(@Valid @RequestBody ContactMessageRequest contactMessageRequest){

        contactMessageService.saveContactMessage(contactMessageRequest);

        Map<String,String> response=new HashMap<>();
        response.put("message","Your message has been successfully saved");
        response.put("status","success");


        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ContactMessageResponse>> getAll(){

        List<ContactMessageResponse> messages= contactMessageService.getContactMessages();



       return new ResponseEntity<>(messages,HttpStatus.OK);

    }



    @GetMapping("/searchByEmail")
    public ResponseEntity<Page<ContactMessageResponse>> searchByEmail(@RequestParam( "page") int page,
                                                                      @RequestParam( "size") int size,
                                                                      @RequestParam("sort") String prop,
                                                                      @RequestParam ("direction")Sort.Direction direction, @RequestBody String email){

        Pageable pageable= PageRequest.of(page,size,Sort.by(direction,prop));

        Page<ContactMessageResponse> contactMessageResponses=contactMessageService.getContactMessageByEmail(email,pageable);


        return new ResponseEntity<>(contactMessageResponses,HttpStatus.OK);

    }


}
