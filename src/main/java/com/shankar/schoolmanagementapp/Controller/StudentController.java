package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shankar.schoolmanagementapp.entities.Student;
import com.shankar.schoolmanagementapp.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public String displayStudent(Model model) {

        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);

        return "student/student";
    }

    @GetMapping("/new")
    public String displayStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/new-student";

    }
    
    @PostMapping("/save")
    public String createStudent(Model model, Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";

    }

    @GetMapping("/update")
    public String updateStudentForm(Model model , @RequestParam("id") Integer studentId){
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "student/new-student";
    }

    @GetMapping("/delete")
    public String deleteStudentForm(Model model, @RequestParam("id") Integer studentId){
        Student student = studentService.getStudentById(studentId);
        studentService.deleteStudent(student);
        return "redirect:/students";

    }


}
