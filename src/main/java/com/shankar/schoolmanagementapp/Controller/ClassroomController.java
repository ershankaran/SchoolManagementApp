package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.schoolmanagementapp.dao.ClassroomRepository;
import com.shankar.schoolmanagementapp.entities.Classroom;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    ClassroomRepository classroomRepo;

    @GetMapping
    public String displayClassroom(Model model){
        Classroom classroom = new Classroom();
        List<Classroom> classrooms = classroomRepo.findAll();
        System.out.println(classrooms);
        model.addAttribute("classroom", classroom);
        model.addAttribute("classrooms", classrooms);
        return "classroom/classroom";
    }

    @PostMapping("/save")
    public String createClassroom(Model model, Classroom classroom){
        classroomRepo.save(classroom);
        return "redirect:/classrooms";
    }
    
}
