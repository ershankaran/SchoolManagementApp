package com.shankar.schoolmanagementapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.schoolmanagementapp.dao.ClassroomRepository;
import com.shankar.schoolmanagementapp.dto.ClassroomStudent;
import com.shankar.schoolmanagementapp.entities.Classroom;

@Service
public class ClassromService {

    @Autowired
    ClassroomRepository classroomRepo;

    public Classroom saveClassroom(Classroom clsrm){
        return classroomRepo.save(clsrm);
    }

    public List<Classroom> getAllClassrooms(){
        return  classroomRepo.findAll();
    }

    public Classroom getClassroom(Classroom clsrm){
        return classroomRepo.findById(clsrm.getClassroomId()).get();
    }

    public Classroom getClassroomById(Integer classroomId){
        return classroomRepo.findById(classroomId).get();
    }

    public List<ClassroomStudent> getclassroomStudentCount(){
        return classroomRepo.getclassroomStudentCount();
    }

    public void deleteClassroom(Classroom classroom){
         classroomRepo.delete(classroom);
    }


    
}
