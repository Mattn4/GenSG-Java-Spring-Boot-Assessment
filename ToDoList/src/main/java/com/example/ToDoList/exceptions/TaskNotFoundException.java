package com.example.ToDoList.exceptions;


public class TaskNotFoundException extends RuntimeException {

  //  private static final long serialVersionUID = 1L;

    public TaskNotFoundException(Long id) {
        super("Could not find task id " + id);
    }
}
