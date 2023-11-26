package com.example.ToDoList.exceptions;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException() {
        super("No task(s) found");
    }
}