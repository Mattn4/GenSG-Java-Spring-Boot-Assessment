package com.example.ToDoList.exceptions;

public class TaskNotFoundException extends RuntimeException {

 //   private static final long serialVersionUID = 1L;

    public TaskNotFoundException() {
        super("No task(s) found");
    }

}