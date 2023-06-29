package com.shankar.schoolmanagementapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.schoolmanagementapp.dao.ClassroomRepository;
import com.shankar.schoolmanagementapp.dto.ClassroomStudent;
import com.shankar.schoolmanagementapp.entities.Classroom;

@Service
public class ClassromService {

    @Autowired
    ClassroomRepository classroomRepo;

    public Classroom save(Classroom clsrm){
        return classroomRepo.save(clsrm);
    }

    public List<Classroom> getAllClassrooms(){
        return  classroomRepo.findAll();
    }

    public Optional<Classroom> getClassroom(Classroom clsrm){
        return classroomRepo.findById(clsrm.getClassroomId());
    }

    public List<ClassroomStudent> getclassroomStudentCount(){
        return classroomRepo.getclassroomStudentCount();
    }


    
}
