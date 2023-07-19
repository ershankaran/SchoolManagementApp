package com.shankar.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shankar.schoolmanagementapp.dto.ClassroomStudent;
import com.shankar.schoolmanagementapp.entities.Classroom;
import com.shankar.schoolmanagementapp.entities.Student;

public interface ClassroomRepository extends CrudRepository<Classroom , Integer> {

    @Override
    public List<Classroom> findAll();


    @Query(nativeQuery = true , value = "select  c.classroom_name as classroomName ,"
    +"count(s.student_id) as studentCount from CLASSROOM c , Student s "
    +"where c.classroom_id = s.classroom_id "
    +"group by classroomName"  )
    public List<ClassroomStudent> getclassroomStudentCount();

   
    
}
