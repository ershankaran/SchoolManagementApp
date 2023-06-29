package com.shankar.schoolmanagementapp.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shankar.schoolmanagementapp.entities.Classroom;

@SpringBootTest
// @ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)

public class ClassroomRepositoryIntegrationTest {

    @Autowired
    ClassroomRepository classroomRepo;

    @Test
    public void ifNewClassroomSaved_thenSuccess(){
        Classroom newClassroom = new Classroom("Test Classroom","testclsroom@tst.org");
        classroomRepo.save(newClassroom);
        List<Classroom> testdata = classroomRepo.findAll();
        testdata.forEach((n) -> System.out.println(n.getClassroomName()));
        assertEquals(1, classroomRepo.findAll().size());
    }
    
}
