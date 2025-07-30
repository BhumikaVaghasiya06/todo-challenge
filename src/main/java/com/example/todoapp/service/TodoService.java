package com.example.todoapp.service;

import com.example.todoapp.model.Task;

import java.util.List;

public interface TodoService {
    List<Task> getTasks();
    boolean addTask(String description);
    void deleteTask(int index);
    void toggleTaskCompletion(int index);

}
