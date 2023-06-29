package com.shankar.schoolmanagementapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.schoolmanagementapp.dao.StudentRepository;
import com.shankar.schoolmanagementapp.entities.Student;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    public Student saveStudent(Student stu){
        return studentRepo.save(stu);
    }

    public List<Student>  getAllStudents(){
        return studentRepo.findAll();
    }

    public Iterable<Student> getStudentsById(List<Integer> studentIds){
        return studentRepo.findAllById(studentIds);
    }
    
    
}
