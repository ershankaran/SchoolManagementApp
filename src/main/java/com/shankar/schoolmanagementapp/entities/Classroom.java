package com.shankar.schoolmanagementapp.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shankar.schoolmanagementapp.Validation.UniqueValue;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Classroom implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "classroom_seq")
    @SequenceGenerator(name = "classroom_seq",sequenceName = "classroom_seq", allocationSize = 1)
    private int classroomId;

    @NotBlank
    @Size(min=2,max=50)
    private String classroomName;

    @NotBlank
    @Email
    @UniqueValue
    private String classroomEmail;

    @OneToMany(mappedBy = "classroom",cascade = {CascadeType.DETACH ,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.LAZY)
    // @JsonManagedReference
    private List<Student> students;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH ,CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    @JoinTable( name="classroom_teacher",
    joinColumns = @JoinColumn(name="classroom_id"),
    inverseJoinColumns =  @JoinColumn(name="teacher_id"))
    private List<Teacher> teachers;
    @JsonIgnore
    public Classroom() {
    }

    public Classroom(String classroomName, String classroomEmail, List<Student> students, List<Teacher> teachers) {
        this.classroomName = classroomName;
        this.classroomEmail = classroomEmail;
        this.students = students;
        this.teachers = teachers;
    }

    public Classroom(String classroomName, String classroomEmail) {
        this.classroomName = classroomName;
        this.classroomEmail = classroomEmail;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getClassroomEmail() {
        return classroomEmail;
    }

    public void setClassroomEmail(String classroomEmail) {
        this.classroomEmail = classroomEmail;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }


    
    

    
    
}
