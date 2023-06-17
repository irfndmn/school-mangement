package com.schoolmanagement.service;

import com.schoolmanagement.domain.concrete.Teacher;
import com.schoolmanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;


    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
