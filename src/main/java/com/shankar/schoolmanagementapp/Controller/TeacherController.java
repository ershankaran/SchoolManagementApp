package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.schoolmanagementapp.entities.Teacher;
import com.shankar.schoolmanagementapp.services.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public String displayTeacher(Model model){
        Teacher teacher = new Teacher();
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teacher", teacher);
        model.addAttribute("teachers", teachers);
        return "teacher/teacher";
    }
    
    @PostMapping("/save")
    public String createTeacher(Model model,Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }
}
