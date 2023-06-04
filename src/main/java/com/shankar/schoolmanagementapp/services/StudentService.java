package com.shankar.schoolmanagementapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.schoolmanagementapp.dao.StudentRepository;

@Service
public class StudentService {
    
    // Field Injection
    @Autowired
    StudentRepository studentRepo;

    

    // Constructor Injection
        // StudentRepository studentRepo;
        
        // public StudentService(StudentRepository studentRepo) {
        //     super();
        //     this.studentRepo = studentRepo;
        // }

    // Setter Injection
        // @Autowired
        // public void setStudentRepo(StudentRepository studentRepo) {
        //     this.studentRepo = studentRepo;
        // }

    

    
}
