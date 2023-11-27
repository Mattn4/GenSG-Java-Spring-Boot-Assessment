package com.example.ToDoList.services;

import com.example.ToDoList.models.Task;
import com.example.ToDoList.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(@Autowired TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTask(Long id){
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAllCompletedTask() {
        return taskRepository.findByCompletedTrue();
    }
//    public List<Task> findAllCompletedTask() {
//        return taskRepository.findByCompletedIs("yes");
//    }

    @Override
    public List<Task> findAllInCompleteTask() {
        return taskRepository.findByCompletedFalse();
    }
//    public List<Task> findAllInCompleteTask() {
//        return taskRepository.findByCompletedIs("no");
//    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {

        Optional<Task> result = taskRepository.findById(id);

        try {
            Task temp = result.get();
            temp.setTask(task.getTask());
            temp.setCompleted(task.getCompleted());
            return Optional.of(taskRepository.save(temp));
        } catch (Exception e) {
            return result;
        }
        
    }

    @Override
    public Optional<Task> findByTaskName(String task){
        return taskRepository.findByTask(task);
    }

}