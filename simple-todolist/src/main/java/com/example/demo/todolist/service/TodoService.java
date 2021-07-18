package com.example.demo.todolist.service;

import com.example.demo.todolist.controller.TodoPostRequest;
import com.example.demo.todolist.domain.Todo;
import com.example.demo.todolist.domain.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public Todo getTodoList(Long id) {
        return todoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 Id의 TodoList가 없습니다. :" + id));
    }

    public Long postTodoList(TodoPostRequest todoPostRequest) {
        return todoRepository.save(todoPostRequest.todoBuilder()).getId();
    }

    public List<Todo> getTodoList(boolean isCompleted) {
        return todoRepository.findAllByIsCompleted(isCompleted);
    }
}
