package com.example.ToDoList.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @SequenceGenerator(name="yourSequenceGenerator", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="yourSequenceGenerator")
    private Long id;

    @Column(unique=true)
    @NotEmpty(message = "task cannot be blank.")
    // @NotBlank annotation must be applied on String field only
    private String task;

    @Column
    @NotNull(message = "task status cannot be blank")
    private Boolean completed;
    // use Boolean : default value is null
    // boolean: default value is false

    public Task() {
    }

    public Task(String task, Boolean completed) {
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
    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}
