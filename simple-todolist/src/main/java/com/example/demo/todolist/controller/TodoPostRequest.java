package com.example.demo.todolist.controller;

import com.example.demo.todolist.domain.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class TodoPostRequest {
    private String startedAt;
    private String finishedAt;
    private String title;
    private String content;
    private boolean isCompleted;

    @Builder
    public TodoPostRequest(String startedAt, String finishedAt, String title, String content, boolean isCompleted) {
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.title = title;
        this.content = content;
        this.isCompleted = isCompleted;
    }

    public Todo todoBuilder(){
        return Todo.builder()
                .title(title)
                .content(content)
                .startedAt(LocalDateTime.parse(startedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .finishedAt(LocalDateTime.parse(finishedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .isCompleted(isCompleted)
                .build();
    }
}
