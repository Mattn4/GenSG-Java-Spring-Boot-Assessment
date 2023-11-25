package com.example.ToDoList.services;

import com.example.ToDoList.models.Task;
import com.example.ToDoList.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService (@Autowired TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

//    public void createNewTask(Task task) {
//        taskRepository.save(task);
//    }

    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(Long id){
        return taskRepository.findById(id);
    }

    public List<Task> findAllCompletedTask() {
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> findAllInCompleteTask() {
        return taskRepository.findByCompletedFalse();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

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

}