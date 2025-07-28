package com.example.todoapp.controller;

import com.example.todoapp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
    private final TodoService todoService;
    // ✅ Manually created constructor
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", todoService.getTasks());
        model.addAttribute("error", null);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String task, Model model) {
        if (!todoService.addTask(task)) {
            model.addAttribute("error", "Task cannot be empty");
            model.addAttribute("tasks", todoService.getTasks());
            return "index";
        }
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam int index) {
        todoService.deleteTask(index);
        return "redirect:/";
    }

    @PostMapping("/toggle")
    public String toggleTaskCompletion(@RequestParam int index) {
        todoService.toggleTaskCompletion(index);
        return "redirect:/";
    }
}
