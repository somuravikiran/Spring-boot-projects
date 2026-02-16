package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String Title;

    private String Description;

    @Column(nullable = false)
    private boolean completed =false;

    private LocalDateTime createdAt=LocalDateTime.now();

    private LocalDateTime completeAt;

    public Todo() {
    }

    public Todo(Long id, String title, String description, boolean completed, LocalDateTime createdAt, LocalDateTime completeAt) {
        Id = id;
        Title = title;
        Description = description;
        this.completed = completed;
        this.createdAt = createdAt;
        this.completeAt = completeAt;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompleteAt() {
        return completeAt;
    }

    public void setCompleteAt(LocalDateTime completeAt) {
        this.completeAt = completeAt;
    }
}
