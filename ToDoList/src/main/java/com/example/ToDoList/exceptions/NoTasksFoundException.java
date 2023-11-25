package com.example.ToDoList.exceptions;

public class NoTasksFoundException extends RuntimeException {

 //   private static final long serialVersionUID = 1L;

    public NoTasksFoundException() {
        super("No task(s) found");
    }

}