package com.shankar.schoolmanagementapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String displayClassroom(Model model) {
        Classroom classroom = new Classroom();
        List<Classroom> classrooms = classroomService.getAllClassrooms();

        model.addAttribute("classroom", classroom);
        model.addAttribute("classrooms", classrooms);

        return "classroom/classroom";
    }

    @GetMapping("/new")
    public String displayClassroomForm(Model model) {
        Classroom aClassroom = new Classroom();
        List<Student> students = studentService.getAllStudents();
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("classroom", aClassroom);
        model.addAttribute("teachers", teachers);
        model.addAttribute("students", students);
        return "classroom/new-classroom";
    }

    @PostMapping("/save")
    public String createClassroom(Model model, Classroom classroom,
            @RequestParam(value = "students") List<Integer> studentIds) {
        System.out.println("id "+classroom.getClassroomId());
        classroomService.saveClassroom(classroom);

        Iterable<Student> classStudents = studentService.getStudentsById(studentIds);

        for (Student stu : classStudents) {
            stu.setClassroom(classroom);
            studentService.saveStudent(stu);
        }

        return "redirect:/classrooms";
    }

    @GetMapping("/update")
    public String updateClassroom(Model model,  @RequestParam("id") Integer classroomId) {

        Classroom existingClassroom = classroomService.getClassroomById(classroomId);
        List<Student> studentsList = studentService.getStudentsByClassroom(existingClassroom);
        List<Teacher> teacherList = teacherService.getclassroomTeacherList(existingClassroom);
      
        model.addAttribute("teachers", teacherList);
        model.addAttribute("students", studentsList);       
        model.addAttribute("classroom", existingClassroom);

        // List<Student> studentsByClassroom = studentService.getStudentsByClassroom(existingClassroom);

        // for (Student stu : studentsByClassroom) {
        //     stu.setClassroom(null);
        //     studentService.saveStudent(stu);
        // }

        // classroomService.saveClassroom(existingClassroom);

        return "classroom/new-classroom";
    }

    @GetMapping("/delete")
    public String deleteClassroom(Model model,@RequestParam("id") Integer classroomId) {
        Classroom existingClassroom = classroomService.getClassroomById(classroomId);
        List<Student> studentsByClassroom = studentService.getStudentsByClassroom(existingClassroom);

        for (Student stu : studentsByClassroom) {
            stu.setClassroom(null);
            studentService.saveStudent(stu);
        }

        classroomService.deleteClassroom(existingClassroom);

        return "redirect:/classrooms";
    }

}
