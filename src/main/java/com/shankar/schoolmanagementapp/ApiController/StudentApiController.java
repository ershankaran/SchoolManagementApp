package com.shankar.schoolmanagementapp.ApiController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.schoolmanagementapp.dao.ClassroomRepository;
import com.shankar.schoolmanagementapp.dao.StudentRepository;
import com.shankar.schoolmanagementapp.entities.Student;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/app-api/students")
public class StudentApiController {

    @Autowired
    ClassroomRepository classroomRepo;

    @Autowired
    StudentRepository studentRepo;



    @GetMapping
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Integer id) {
        return studentRepo.findById(id).get();
    }

    @PostMapping(consumes = { "application/json" })
    @ResponseStatus(HttpStatus.CREATED)
    // @PostMapping
    public @ResponseBody @Valid Student createStudent(@RequestBody @Valid Student student) {

        return studentRepo.save(student);
    }

    @PutMapping(consumes = { "application/json" })
    @ResponseStatus(HttpStatus.OK)
    public @Valid Student updateStudent(@RequestBody @Valid Student student) {

               return studentRepo.save(student);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Student patchUpdateStudent(@PathVariable("id") Integer studentId, @RequestBody @Valid Student student) {
        Student student2 = studentRepo.findById(studentId).get();

        if (student.getStudentEmail() != null) {
            student2.setStudentEmail(student.getStudentEmail());
        }

        if (student.getStudentName() != null) {
            student2.setStudentName(student.getStudentName());
        }

        if (student.getClassroom() != null) {
            student2.setClassroom(student.getClassroom());
        }

        return studentRepo.save(student2);

    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") int studentId) {
        Student student = studentRepo.findById(studentId).get();

        studentRepo.delete(student);
    }

}
