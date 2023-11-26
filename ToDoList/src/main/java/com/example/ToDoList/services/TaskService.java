package com.example.ToDoList.services;

import com.example.ToDoList.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    public abstract Task createNewTask(Task task);

    public abstract List<Task> getAllTask();

    public abstract Optional<Task> getTask(Long id);

    public abstract List<Task> findAllCompletedTask();

    public abstract List<Task> findAllInCompleteTask();

    public abstract void deleteTask(Long id);

    public abstract Optional<Task> updateTask(Long id, Task task);

    public abstract Optional<Task> findByTaskName(String task);

}