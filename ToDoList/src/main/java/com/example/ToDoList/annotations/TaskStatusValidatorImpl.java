package com.example.ToDoList.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class TaskStatusValidatorImpl implements ConstraintValidator<TaskStatusValidator, String> {

    public boolean isValid(String value, ConstraintValidatorContext context) {

        List list = Arrays.asList(new String[]{"yes","no"});
        return list.contains(value);
        // Uses strict validation
        // Accepts ""yes", "no" in lower case & no whitespace
    }

}