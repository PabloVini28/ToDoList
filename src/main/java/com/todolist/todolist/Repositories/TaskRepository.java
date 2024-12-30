package com.todolist.todolist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.todolist.Entities.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
    
}
