package com.shankar.schoolmanagementapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    // @UniqueValue
    private String classroomEmail;

    @OneToMany(mappedBy = "classroom",cascade = {CascadeType.DETACH ,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.LAZY)
    // @JsonManagedReference
    private List<Student> students;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH ,CascadeType.REFRESH,CascadeType.REMOVE},
    fetch = FetchType.LAZY)
    @JoinTable( name="classroom_teacher",
    joinColumns = @JoinColumn(name="classroom_id"),
    inverseJoinColumns =  @JoinColumn(name="teacher_id"))
    private List<Teacher> teachers;

    @NotNull
    private Date classroomStartDate;
    @NotNull
    private Date classroomEndDate;

    @JsonIgnore
    public Classroom() {
    }

     


    public Classroom(@NotBlank @Size(min = 2, max = 50) String classroomName, @NotBlank @Email String classroomEmail) {
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

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Date getClassroomStartDate() {
        return classroomStartDate;
    }

    public void setClassroomStartDate(Date classroomStartDate) {
        this.classroomStartDate = classroomStartDate;
    }

    public Date getClassroomEndDate() {
        return classroomEndDate;
    }

    public void setClassroomEndDate(Date classroomEndDate) {
        this.classroomEndDate = classroomEndDate;
    }


    
    

    
    
}
