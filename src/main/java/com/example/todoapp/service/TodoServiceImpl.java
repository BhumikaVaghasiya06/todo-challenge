package com.example.todoapp.service;

import com.example.todoapp.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            return false;
        }
        tasks.add(Task.builder()
                .description(description.trim())
                .build());
        return true;
    }

    @Override
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    @Override
    public void toggleTaskCompletion(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(!task.isCompleted());
        }
    }
}
