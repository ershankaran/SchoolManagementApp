package com.shankar.schoolmanagementapp.Controller;

import org.springframework.stereotype.Controller;

@Controller
public class ClassroomController {

    public String displayClassroom(){
        return "classroom.html";
    }
    
}
