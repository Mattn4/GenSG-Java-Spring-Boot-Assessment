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
            throw new NoTasksFoundException(); // did not show message
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

//    public ResponseEntity<Object> getAllTasks() {
//
//        List<Task> result = taskService.getAllTask();
//
//        if(!result.isEmpty()){
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>("No task(s) found", HttpStatus.NOT_FOUND);
//        }
//
//    }

//    public ResponseEntity<List<Task>> getAllTasks() {
//        return ResponseEntity.ok(taskService.getAllTask());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSingleTask(@PathVariable Long id){

        Task result = taskService.getProduct(id).orElseThrow(() -> new TaskNotFoundException(id));
        return new ResponseEntity<>(result, HttpStatus.OK);

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
