package com.example.ToDoList.controllers;

import com.example.ToDoList.models.Task;
import com.example.ToDoList.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    TaskService taskService;

    public TaskController(@Autowired TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.findAllCompletedTask());
        //return new ResponseEntity<>(taskService.findAllCompletedTask(), HttpStatus.OK);
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getAllIncompleteTasks() {
        return ResponseEntity.ok(taskService.findAllInCompleteTask());
        //return new ResponseEntity<>(taskService.findAllInCompleteTask(), HttpStatus.OK);
    }

//    @PostMapping()
//    public ResponseEntity<Object> createTask(@Valid @RequestBody Task task) {
//        return new ResponseEntity<>(taskService.createNewTask(task), HttpStatus.CREATED);
//    }

    @PostMapping()
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

//    @PostMapping()
//    public ResponseEntity<Object> createTask(@RequestBody Task task) {
//        taskService.createNewTask(task);
//        return new ResponseEntity<>("Task is created successfully!!", HttpStatus.CREATED);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
        //return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>("Task is deleted successfully.", HttpStatus.OK);
    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteTasks(@PathVariable("id") Long id){
//        String deletedtask = taskService.findTaskById(id).getTask();
//        taskService.deleteTask(id);
//        return ResponseEntity.ok("Task of " + deletedtask + "  is deleted successfully!.");
//    }


}
