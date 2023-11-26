package com.example.ToDoList.models;

import com.example.ToDoList.annotations.TaskStatusValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @SequenceGenerator(name="yourSequenceGenerator", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="yourSequenceGenerator")
    private Long id;

    @Column(unique=true)
    @NotEmpty(message = "task cannot be blank.")
    // @NotBlank annotation must be applied on any String field only
    private String task;

    @Column
    @TaskStatusValidator
    //@NotEmpty(message = "task status cannot be blank")
    private String completed;

    public Task() {
    }

    public Task(String task, String completed) {
        this.task = task;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public String getCompleted() {
        return completed;
    }
    public void setCompleted(String completed) {
        this.completed = completed;
    }

}
