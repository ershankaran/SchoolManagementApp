package com.shankar.schoolmanagementapp.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student {
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    @SequenceGenerator(name = "student_seq",sequenceName = "student_seq", allocationSize = 1)
    private int studentId;
    private String studentName;
    private String studentEmail;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
    fetch = FetchType.LAZY)
    @JoinColumn(name="classroom_id")
    private Classroom classroom;


    public Student(String studentName, String studentEmail, Classroom classroom) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.classroom = classroom;
    }


    public Student() {
    }


    public int getStudentId() {
        return studentId;
    }


    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public String getStudentName() {
        return studentName;
    }


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getStudentEmail() {
        return studentEmail;
    }


    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }


    public Classroom getClassroom() {
        return classroom;
    }


    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    
    


}
