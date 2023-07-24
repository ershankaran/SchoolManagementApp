package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shankar.schoolmanagementapp.entities.Teacher;
import com.shankar.schoolmanagementapp.services.TeacherService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public String displayTeacher(Model model) {

        List<Teacher> teachers = teacherService.getAllTeachers();

        model.addAttribute("teachers", teachers);
        return "teacher/teacher";
    }

    @GetMapping("/new")
    public String displayTeacherForm(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "teacher/new-teacher";

    }

    @PostMapping("/save")
    public String createTeacher(Model model, @Valid Teacher teacher, Errors errors) {

        if (errors.hasErrors()) {
            return "teacher/new-teacher";
        }
        
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/update")
    public String updateTeacherForm(Model model, @RequestParam("id") Integer teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        model.addAttribute("teacher", teacher);
        return "teacher/new-teacher";
    }

    @GetMapping("/delete")
    public String deleteTeacherForm(Model model, @RequestParam("id") Integer teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        teacherService.deleteTeacher(teacher);
        return "redirect:/teachers";
    }
}
