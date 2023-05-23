package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shankar.schoolmanagementapp.dao.ClassroomRepository;
import com.shankar.schoolmanagementapp.dao.StudentRepository;
import com.shankar.schoolmanagementapp.dao.TeacherRepositroy;
import com.shankar.schoolmanagementapp.entities.Classroom;
import com.shankar.schoolmanagementapp.entities.Student;
import com.shankar.schoolmanagementapp.entities.Teacher;

@Controller
public class HomeController {
    
    @Autowired
    StudentRepository studentRepo;

    @Autowired
    TeacherRepositroy teacherRepo;

    @Autowired
    ClassroomRepository classroomRepo;

    @GetMapping("/")
    public String displayHomePage(Model model){
        List<Student> students = studentRepo.findAll();
        List<Teacher> teachers = teacherRepo.findAll();
        List<Classroom> classrooms = classroomRepo.findAll();
        model.addAttribute("students", students);
        model.addAttribute("teachers", teachers);
        model.addAttribute("classrooms", classrooms);
        return "index.html";
    }
}
