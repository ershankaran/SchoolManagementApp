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
import com.shankar.schoolmanagementapp.dao.TeacherRepositroy;
import com.shankar.schoolmanagementapp.entities.Teacher;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app-api/teachers")
public class TeacherApiController {

    @Autowired
    ClassroomRepository classroomRepo;

    @Autowired
    StudentRepository studentRepo;

    @Autowired
    TeacherRepositroy teacherRepo;

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable("id") Integer id) {
        return teacherRepo.findById(id).get();
    }

    @PostMapping(consumes = { "application/json" })
    @ResponseStatus(HttpStatus.CREATED)
    // @PostMapping
    public @ResponseBody @Valid Teacher createTeacher(@RequestBody @Valid Teacher teacher) {

        return teacherRepo.save(teacher);
    }

    @PutMapping(consumes = { "application/json" })
    @ResponseStatus(HttpStatus.OK)
    public @Valid Teacher updateTeacher(@RequestBody @Valid Teacher teacher) {

        return teacherRepo.save(teacher);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Teacher patchUpdateTeacher(@PathVariable("id") Integer teacherId, @RequestBody @Valid Teacher teacher) {
        
        Teacher teacherOld = teacherRepo.findById(teacherId).get();

        if (teacher.getTeacherName() != null) {
            teacherOld.setTeacherName(teacher.getTeacherName());
        }

        if (teacher.getTeacherEmail() != null) {
            teacherOld.setTeacherEmail(teacher.getTeacherEmail());
        }

        if (teacher.getClassroom() != null) {
            teacherOld.setClassroom(teacher.getClassroom());
        }

        return teacherRepo.save(teacherOld);

    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable("id") int teacherId) {
        Teacher teacher = teacherRepo.findById(teacherId).get();

        teacherRepo.delete(teacher);
    }
}
