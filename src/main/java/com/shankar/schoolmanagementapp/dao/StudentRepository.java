package com.shankar.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shankar.schoolmanagementapp.entities.Classroom;
import com.shankar.schoolmanagementapp.entities.Student;

public interface StudentRepository extends CrudRepository<Student,Integer>{

    @Override
    public List<Student> findAll();

    
    public List<Student> findByClassroom(Classroom classroom);
    
}
