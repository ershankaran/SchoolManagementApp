package com.shankar.schoolmanagementapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
public class TeacherController {


    @GetMapping
    public String displayTeacher(){
        return "teacher.html";
    }
    
}
