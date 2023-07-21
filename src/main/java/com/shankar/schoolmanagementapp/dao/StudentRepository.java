package com.shankar.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shankar.schoolmanagementapp.entities.Classroom;
import com.shankar.schoolmanagementapp.entities.Student;
@RepositoryRestResource(collectionResourceRel = "apiStudents",path = "apiStudents")
public interface StudentRepository extends CrudRepository<Student,Integer>,PagingAndSortingRepository<Student,Integer>{

    @Override
    public List<Student> findAll();

    //property expressions
    public List<Student> findByClassroom(Classroom classroom);
    
}
