package com.example.ToDoList.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateTaskNameException extends SQLIntegrityConstraintViolationException {

    public DuplicateTaskNameException() {
        super("Task already exists");
    }
    // Exception for creating a new task only
    // If the task name is already existed in database, this exception is thrown
    // Even if the task status is different
}
