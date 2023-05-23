package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.schoolmanagementapp.dao.TeacherRepositroy;
import com.shankar.schoolmanagementapp.entities.Teacher;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherRepositroy teacherRepo;

    @GetMapping
    public String displayTeacher(Model model){
        Teacher teacher = new Teacher();
        List<Teacher> teachers = teacherRepo.findAll();
        model.addAttribute("teacher", teacher);
        model.addAttribute("teachers", teachers);
        return "teacher/teacher";
    }
    
    @PostMapping("/save")
    public String createTeacher(Model model,Teacher teacher){
        teacherRepo.save(teacher);
        return "redirect:/teachers";
    }
}
