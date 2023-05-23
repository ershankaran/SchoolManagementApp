package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shankar.schoolmanagementapp.dao.ClassroomRepository;
import com.shankar.schoolmanagementapp.dao.StudentRepository;
import com.shankar.schoolmanagementapp.dao.TeacherRepositroy;
import com.shankar.schoolmanagementapp.entities.Classroom;
import com.shankar.schoolmanagementapp.entities.Student;
import com.shankar.schoolmanagementapp.entities.Teacher;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    ClassroomRepository classroomRepo;

    @Autowired
    TeacherRepositroy teacherRepo;

    @Autowired
    StudentRepository studentRepo;

    @GetMapping
    public String displayClassroom(Model model){
        Classroom classroom = new Classroom();
        List<Classroom> classrooms = classroomRepo.findAll();
        List<Student> students = studentRepo.findAll();
        List<Teacher> teachers = teacherRepo.findAll();
        model.addAttribute("classroom", classroom);
        model.addAttribute("classrooms", classrooms);
        model.addAttribute("teachers", teachers);
        model.addAttribute("students", students);
        return "classroom/classroom";
    }

    @PostMapping("/save")
    public String createClassroom(Model model, Classroom classroom, @RequestParam(value="students") List<Integer>studentIds){
        classroomRepo.save(classroom);

        Iterable<Student> classStudents = studentRepo.findAllById(studentIds);

        for(Student stu : classStudents){
            stu.setClassroom(classroom);
            studentRepo.save(stu);
        }

        return "redirect:/classrooms";
    }
    
}
