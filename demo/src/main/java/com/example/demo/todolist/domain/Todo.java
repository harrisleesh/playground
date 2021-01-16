package com.example.demo.todolist.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    private String title;
    private String content;
    private boolean isCompleted;

    @Builder
    public Todo(LocalDateTime startedAt, LocalDateTime finishedAt, String title, String content, boolean isCompleted) {
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.title = title;
        this.content = content;
        this.isCompleted = isCompleted;
    }
}
