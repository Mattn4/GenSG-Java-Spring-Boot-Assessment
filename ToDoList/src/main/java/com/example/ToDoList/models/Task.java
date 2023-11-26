package com.example.ToDoList.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @SequenceGenerator(name="yourSequenceGenerator", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="yourSequenceGenerator")
    private Long id;

    @Column(unique=true)
    @NotBlank(message = "task cannot be blank.")
    // @NotBlank annotation must be applied on any String field only
    private String task;

    @Column
    @NotNull(message = "task status cannot be blank")
    private boolean completed;

    public Task() {
    }

    public Task(String task, boolean completed) {
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
    public boolean getCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
