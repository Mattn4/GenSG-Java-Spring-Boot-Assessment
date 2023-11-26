package com.example.ToDoList.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateTaskNameException extends SQLIntegrityConstraintViolationException {

    public DuplicateTaskNameException() {
        super("Task already exist");
    }

}
