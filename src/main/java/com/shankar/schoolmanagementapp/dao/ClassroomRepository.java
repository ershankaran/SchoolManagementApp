package com.shankar.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shankar.schoolmanagementapp.entities.Classroom;

public interface ClassroomRepository extends CrudRepository<Classroom , Integer> {

    @Override
    public List<Classroom> findAll();
    
}
