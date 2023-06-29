package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shankar.schoolmanagementapp.entities.Classroom;
import com.shankar.schoolmanagementapp.entities.Student;
import com.shankar.schoolmanagementapp.entities.Teacher;
import com.shankar.schoolmanagementapp.services.ClassromService;
import com.shankar.schoolmanagementapp.services.StudentService;
import com.shankar.schoolmanagementapp.services.TeacherService;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    ClassromService classroomService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @GetMapping
    public String displayClassroom(Model model){
        Classroom classroom = new Classroom();
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        List<Student> students = studentService.getAllStudents();
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("classroom", classroom);
        model.addAttribute("classrooms", classrooms);
        model.addAttribute("teachers", teachers);
        model.addAttribute("students", students);
        return "classroom/classroom";
    }

    @PostMapping("/save")
    public String createClassroom(Model model, Classroom classroom, @RequestParam(value="students") List<Integer>studentIds){
        classroomService.save(classroom);

        Iterable<Student> classStudents = studentService.getStudentsById(studentIds);

        for(Student stu : classStudents){
            stu.setClassroom(classroom);
            studentService.saveStudent(stu);
        }

        return "redirect:/classrooms";
    }
    
}
