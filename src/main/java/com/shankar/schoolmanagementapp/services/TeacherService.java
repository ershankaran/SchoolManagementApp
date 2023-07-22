package com.shankar.schoolmanagementapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.schoolmanagementapp.dao.TeacherRepositroy;
import com.shankar.schoolmanagementapp.dto.ClassroomTeacher;
import com.shankar.schoolmanagementapp.entities.Classroom;
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

    public List<Teacher> getclassroomTeacherList(Classroom classroom){
        System.out.println("clsrm id "+classroom.getClassroomId());
        List<Integer> getclassroomTeacherList = teacherRepo.getclassroomTeacherList(classroom.getClassroomId());
        System.out.println("Teacher list"+getclassroomTeacherList);
        List<Teacher> teachersList = new ArrayList<>();
        for(int id : getclassroomTeacherList){
            teachersList.add(teacherRepo.findById(id).get());
        }

        return teachersList;
    }

    public Teacher getTeacherById(Integer teacherId) {
        return teacherRepo.findById(teacherId).get();
    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepo.delete(teacher);
    }
    
}
