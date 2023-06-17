package com.schoolmanagement.controller;

import com.schoolmanagement.domain.concrete.Teacher;
import com.schoolmanagement.service.TeacherService;
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
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping("/new")
    public ResponseEntity<Map<String,String>> createTeacher(@Valid @RequestBody Teacher teacher){

        teacherService.saveTeacher(teacher);
        Map<String,String> response=new HashMap<>();
        response.put("Message","has created successfuly...");
        response.put("Status","succerss");
        return new ResponseEntity<>(response, HttpStatus.OK);


    }




}
