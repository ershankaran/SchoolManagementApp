package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shankar.schoolmanagementapp.dto.ClassroomStudent;
import com.shankar.schoolmanagementapp.dto.ClassroomTeacher;
import com.shankar.schoolmanagementapp.entities.Classroom;
import com.shankar.schoolmanagementapp.entities.Student;
import com.shankar.schoolmanagementapp.entities.Teacher;
import com.shankar.schoolmanagementapp.services.ClassromService;
import com.shankar.schoolmanagementapp.services.StudentService;
import com.shankar.schoolmanagementapp.services.TeacherService;

@Controller
public class HomeController {

    @Value("${version}")
    private String ver;
    
    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ClassromService classroomService;

    @GetMapping("/")
    public String displayHomePage(Model model) throws JsonProcessingException{
        List<Student> students = studentService.getAllStudents();
        List<Teacher> teachers = teacherService.getAllTeachers();
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        List<ClassroomStudent> chartData = classroomService.getclassroomStudentCount();

        List<ClassroomTeacher> chartData2 = teacherService.getTeacherClassroomCount();
        
        ObjectMapper objectMapper = new ObjectMapper();
        String getclassroomStudentCount = objectMapper.writeValueAsString(chartData);
        String getclassroomTeacherCount = objectMapper.writeValueAsString(chartData2);
        model.addAttribute("students", students);
        model.addAttribute("teachers", teachers);
        model.addAttribute("classrooms", classrooms);
        model.addAttribute("getclassroomStudentCount", getclassroomStudentCount);
        model.addAttribute("getclassroomTeacherCount", getclassroomTeacherCount);
        model.addAttribute("versionNumber", ver);
        return "index.html";
    }
}
