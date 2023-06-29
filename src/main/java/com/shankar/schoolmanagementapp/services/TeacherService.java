package com.shankar.schoolmanagementapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.schoolmanagementapp.dao.TeacherRepositroy;
import com.shankar.schoolmanagementapp.dto.ClassroomTeacher;
import com.shankar.schoolmanagementapp.entities.Teacher;
@Service
public class TeacherService {

    @Autowired
    TeacherRepositroy teacherRepo;

    public Teacher saveTeacher(Teacher tchr){
        return teacherRepo.save(tchr);
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepo.findAll();
    }

    public List<ClassroomTeacher> getTeacherClassroomCount(){
        return teacherRepo.getclassroomTeacherCount();
    }
    
}
