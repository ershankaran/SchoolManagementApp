package com.shankar.schoolmanagementapp.Validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.shankar.schoolmanagementapp.dao.ClassroomRepository;
import com.shankar.schoolmanagementapp.entities.Classroom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<UniqueValue,String> {

    @Autowired
    ClassroomRepository classroomRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Classroom classroomEmail = classroomRepo.findByClassroomEmail(value);

        if(classroomEmail != null){
            return false;
        } else {
            return true;
        }

    }
    
}
