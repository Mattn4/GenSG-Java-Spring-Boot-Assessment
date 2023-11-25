package com.example.ToDoList.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @SequenceGenerator(name="yourSequenceGenerator", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="yourSequenceGenerator")
    private Long id;

    @Column
 //   @NotBlank(message = "task cannot be blank.")
    private String task;

    @Column
  //  @NotBlank(message = "please indicate the task completion status")
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
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
