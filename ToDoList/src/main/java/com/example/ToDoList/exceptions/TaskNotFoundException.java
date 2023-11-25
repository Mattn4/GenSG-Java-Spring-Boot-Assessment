package com.example.ToDoList.exceptions;


public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Could not find task of id " + id);
    }
}
