package com.shankar.schoolmanagementapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.shankar.schoolmanagementapp.entities.Teacher;

public interface TeacherRepositroy extends CrudRepository<Teacher,Integer>{
    
}
