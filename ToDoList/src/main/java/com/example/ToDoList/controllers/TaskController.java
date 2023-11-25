package com.example.ToDoList.controllers;

import com.example.ToDoList.exceptions.NoTasksFoundException;
import com.example.ToDoList.exceptions.TaskNotFoundException;
import com.example.ToDoList.models.Task;
import com.example.ToDoList.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    TaskService taskService;

    public TaskController(@Autowired TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllTasks() {

        List<Task> result = taskService.getAllTask();

        if(result.isEmpty()) {
            throw new NoTasksFoundException();
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSingleTask(@PathVariable Long id){

        Task result = taskService.getTask(id).orElseThrow(() -> new TaskNotFoundException(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/completed")
    public ResponseEntity<Object> getAllCompletedTasks() {

        List<Task> result = taskService.findAllCompletedTask();

        if(result.isEmpty()) {
            throw new NoTasksFoundException();
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/incomplete")
    public ResponseEntity<Object> getAllIncompleteTasks() {

        List<Task> result = taskService.findAllInCompleteTask();

        if(result.isEmpty()) {
            throw new NoTasksFoundException();
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> createTask(@Valid @RequestBody Task task) {
        return new ResponseEntity<>(taskService.createNewTask(task), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable Long id, @Valid @RequestBody Task task) {

        taskService.getTask(id).orElseThrow(() -> new TaskNotFoundException(id));
        Optional<Task> result = taskService.updateTask(id, task);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable Long id) {

        taskService.getTask(id).orElseThrow(() -> new TaskNotFoundException(id));
        taskService.deleteTask(id);

        return new ResponseEntity<>("Task is deleted successfully.", HttpStatus.OK);
    }

}
