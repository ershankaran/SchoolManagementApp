package com.shankar.schoolmanagementapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.schoolmanagementapp.entities.Teacher;

@Controller
@RequestMapping("/teachers")
public class TeacherController {


    @GetMapping
    public String displayTeacher(Model model){
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "teacher/teacher";
    }
    
}
