package com.shankar.schoolmanagementapp.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Teacher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;
    private String teacherName;
    private String teacherEmail;
    
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
    fetch = FetchType.LAZY)
    @JoinColumn(name="classroom_id")
    private List<Classroom> classroom;

    public Teacher() {
    }

    public Teacher(String teacherName, String teacherEmail, List<Classroom> classroom) {
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.classroom = classroom;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public List<Classroom> getClassroom() {
        return classroom;
    }

    public void setClassroom(List<Classroom> classroom) {
        this.classroom = classroom;
    }


    


    

    
}
