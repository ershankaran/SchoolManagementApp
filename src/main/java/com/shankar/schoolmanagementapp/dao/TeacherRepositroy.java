package com.shankar.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shankar.schoolmanagementapp.dto.ClassroomTeacher;
import com.shankar.schoolmanagementapp.entities.Teacher;

public interface TeacherRepositroy extends CrudRepository<Teacher,Integer>{

    @Override
    public List<Teacher> findAll();

    @Query(nativeQuery = true , value = "select  c.classroom_name as classroomName ,"
    +"count(t.teacher_id) as teacherCount from CLASSROOM c , classroom_teacher t "
    +"where c.classroom_id = t.classroom_id "
    +"group by classroomName"  )
    public List<ClassroomTeacher> getclassroomTeacherCount();
    
}
