package com.shankar.schoolmanagementapp.ApiController;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.shankar.schoolmanagementapp.dao.ClassroomRepository;
import com.shankar.schoolmanagementapp.dao.StudentRepository;
import com.shankar.schoolmanagementapp.dao.TeacherRepositroy;
import com.shankar.schoolmanagementapp.entities.Classroom;
import com.shankar.schoolmanagementapp.entities.Student;
import com.shankar.schoolmanagementapp.entities.Teacher;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/app-api/classrooms")
public class ClassroomApiController {

    @Autowired
    ClassroomRepository classroomRepo;

    @Autowired
    StudentRepository studentRepo;

    @Autowired
    TeacherRepositroy teacherRepository;

    @GetMapping
    public List<Classroom> getClassrooms() {
        return classroomRepo.findAll();
    }

    @GetMapping("/{id}")
    public Classroom getClassroom(@PathVariable("id") Integer id) {
        return classroomRepo.findById(id).get();
    }

    @PostMapping(consumes = { "application/json" })
    @ResponseStatus(HttpStatus.CREATED)
    // @PostMapping
    public @ResponseBody Classroom createClassroom(@RequestBody @Valid Classroom classroom) {

        return classroomRepo.save(classroom);
    }

    @PutMapping(consumes = { "application/json" })
    @ResponseStatus(HttpStatus.OK)
    public Classroom updateClassroom(@RequestBody @Valid Classroom classroom) {
        List<Student> classStudents = classroom.getStudents();

        for (Student stu : classStudents) {
            stu.setClassroom(classroom);
            studentRepo.save(stu);
        }

        return classroomRepo.save(classroom);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Classroom patchUpdateClassroom(@PathVariable("id") Integer classroomId, @RequestBody @Valid Classroom classroom) {
        Classroom classroom2 = classroomRepo.findById(classroomId).get();

        if (classroom.getClassroomEmail() != null) {
            classroom2.setClassroomEmail(classroom.getClassroomEmail());
        }

        if (classroom.getClassroomName() != null) {
            classroom2.setClassroomName(classroom.getClassroomName());
        }

        if (classroom.getStudents() != null) {
            List<Student> classStudents = classroom.getStudents();

            List<Student> existingClassroomStudents = studentRepo.findByClassroom(classroom2);
            List<Student> studentsToDelete = existingClassroomStudents.stream()
                    .filter(student -> !classStudents.contains(student))
                    .collect(Collectors.toList());
            List<Student> studentsToAdd = classStudents.stream()
                    .filter(student -> !existingClassroomStudents.contains(student))
                    .collect(Collectors.toList());

            if (studentsToDelete.size() > 0) {
                for (Student stu : studentsToDelete) {
                    stu.setClassroom(null);
                    studentRepo.save(stu);
                }
            }

            if (studentsToAdd.size() > 0) {
                for (Student stu : studentsToAdd) {
                    stu.setClassroom(classroom);
                    studentRepo.save(stu);
                }
            }

            System.out.println("Hello");
        }

        if (classroom.getTeachers() != null) {
            List<Teacher> teachers = classroom.getTeachers();

            classroom2.setTeachers(teachers);
        }

        return classroomRepo.save(classroom2);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClassroom(@PathVariable("id") Integer classroomId) throws Exception {
        Classroom findById = classroomRepo.findById(classroomId).get();
        System.out.println(findById.getClassroomId());

        try {
            if (findById.getClassroomId() != 0) {

                List<Student> classStudents = studentRepo.findByClassroom(findById);

                if (classStudents.size() > 0) {
                    for (Student stu : classStudents) {
                        stu.setClassroom(null);
                        studentRepo.save(stu);
                    }
                }

                classroomRepo.delete(findById);

            } else {
                throw new ObjectNotFoundException(classroomId, "Classroom id " + classroomId);
            }

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}