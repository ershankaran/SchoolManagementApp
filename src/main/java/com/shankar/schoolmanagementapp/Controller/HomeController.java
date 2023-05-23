package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shankar.schoolmanagementapp.dao.StudentRepository;
import com.shankar.schoolmanagementapp.entities.Student;

@Controller
public class HomeController {
    
    @Autowired
    StudentRepository studentRepo;

    @GetMapping("/")
    public String displayHomePage(Model model){
        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "index.html";
    }
}
