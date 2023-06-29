package com.shankar.schoolmanagementapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shankar.schoolmanagementapp.dao.StudentRepository;

@Service
public class StudentService {
    
    // Field Injection
    @Autowired
    StudentRepository studentRepo;

    TeacherService teacherService;

    public StudentService( @Qualifier("teacherServiceImpl2") TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    //  error msg -  Parameter 0 of constructor in com.shankar.schoolmanagementapp.services.StudentService required a bean of type 'com.shankar.schoolmanagementapp.services.TeacherService' that could not be found.
    // fix - add @service/@component to any of the implementations

    

    // error msg 2 - Parameter 0 of constructor in com.shankar.schoolmanagementapp.services.StudentService required a single bean, but 2 were found
    // fix - arking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed 

    // Qualifier injection can  be used for setter as well as field injections

            // @Qualifier("teacherServiceImpl2")
            // @Autowired
            // TeacherService teacherService;

            // @Qualifier("teacherServiceImpl2")
            // @Autowired
            // public void setTeacherService(TeacherService teacherService) {
            //     this.teacherService = teacherService;
            // }


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
