package com.shankar.schoolmanagementapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.shankar.schoolmanagementapp.entities.Student;

public interface StudentRepositroy extends CrudRepository<Student,Integer>{
    
}
