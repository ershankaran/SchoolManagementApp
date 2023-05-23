package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.schoolmanagementapp.dao.StudentRepository;
import com.shankar.schoolmanagementapp.entities.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepo;


    @GetMapping
    public String displayStudent(Model model){

        Student student = new Student();
        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        model.addAttribute("student", student);

        return "student/student";
    }
    
}
