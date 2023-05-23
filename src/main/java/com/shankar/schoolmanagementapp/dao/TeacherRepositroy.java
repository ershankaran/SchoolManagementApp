package com.shankar.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shankar.schoolmanagementapp.entities.Teacher;

public interface TeacherRepositroy extends CrudRepository<Teacher,Integer>{

    @Override
    public List<Teacher> findAll();
    
}
