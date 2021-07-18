package com.example.demo.todolist.controller;

import com.example.demo.todolist.domain.Todo;
import com.example.demo.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todo/{id}")
    public Todo getTodoList(@PathVariable Long id){
        return todoService.getTodoList(id);
    }

    @GetMapping("/todo")
    public List<Todo> getTodoList(@RequestParam boolean isCompleted){
        return todoService.getTodoList(isCompleted);
    }

    @PostMapping("/todo")
    public Long postTodoList(@RequestBody TodoPostRequest todoPostRequest){
        return todoService.postTodoList(todoPostRequest);
    }
}
