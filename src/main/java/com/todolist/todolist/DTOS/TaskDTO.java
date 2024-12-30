package com.todolist.todolist.DTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class TaskDTO {
    
    private long Id;
    @NotBlank
    private String description;
    @NotBlank
    private String title;
    @NotNull
    private boolean complete;

}
