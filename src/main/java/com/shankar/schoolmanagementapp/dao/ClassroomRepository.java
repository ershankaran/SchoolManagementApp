package com.shankar.schoolmanagementapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.shankar.schoolmanagementapp.entities.Classroom;

public interface ClassroomRepository extends CrudRepository<Classroom , Integer> {
    
}
