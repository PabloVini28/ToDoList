package com.todolist.todolist.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarefas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column (nullable = false)
    private String description;

    @Column (nullable = false)
    private String title;

    @Column
    private boolean complete;

}
