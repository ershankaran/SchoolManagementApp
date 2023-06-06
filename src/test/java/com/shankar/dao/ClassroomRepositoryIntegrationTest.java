package com.shankar.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.shankar.schoolmanagementapp.SchoolmanagementappApplication;
import com.shankar.schoolmanagementapp.dao.ClassroomRepository;
import com.shankar.schoolmanagementapp.entities.Classroom;

@ContextConfiguration(classes=SchoolmanagementappApplication.class)
// @ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD,scripts = {"classpath:schema.sql","classpath:data.sql"})
    ,@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD,scripts = "classpath:drop.sql")})
public class ClassroomRepositoryIntegrationTest {

    @Autowired
    ClassroomRepository classroomRepo;

    @Test
    public void ifNewClassroomSaved_thenSuccess(){
        Classroom newClassroom = new Classroom("Test Classroom","testclsroom@tst.org");
        classroomRepo.save(newClassroom);
        List<Classroom> testdata = classroomRepo.findAll();
        testdata.forEach((n) -> System.out.println(n.getClassroomName()));
        assertEquals(9, classroomRepo.findAll().size());
    }
    
}
