package com.example.todoapp.model;

public class Task {
    private String description;
    private boolean completed;

    // No-arg constructor
    public Task() {
    }

    // All-args constructor
    public Task(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for completed
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Optional: Builder-style static method (manual version of Lombok's builder)
    public static TaskBuilder builder() {
        return new TaskBuilder();
    }

    public static class TaskBuilder {
        private String description;
        private boolean completed;

        public TaskBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TaskBuilder completed(boolean completed) {
            this.completed = completed;
            return this;
        }

        public Task build() {
            return new Task(description, completed);
        }
    }
}


