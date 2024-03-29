package com.shankar.schoolmanagementapp.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shankar.schoolmanagementapp.Validation.UniqueValue;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Student implements Serializable{
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    @SequenceGenerator(name = "student_seq",sequenceName = "student_seq", allocationSize = 1)
    private int studentId;

    @NotNull
    @Size(min=2,max=50)
    private String studentName;

    @NotEmpty
    @Email
    @UniqueValue
    private String studentEmail;
    
    @ManyToOne(cascade  = {CascadeType.DETACH ,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name="classroom_id")
    // @JsonBackReference
    @JsonIgnore
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
