package com.example.ToDoList.exceptions;

public class NoTasksFoundException extends RuntimeException {

    public NoTasksFoundException() {
        super("No task(s) found.");
    }

}