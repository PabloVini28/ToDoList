package com.todolist.todolist.Controllers;

import java.net.URI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.todolist.todolist.DTOS.TaskDTO;
import com.todolist.todolist.Services.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/todolist")
@RequiredArgsConstructor
public class TaskController {
    
    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody @Valid TaskDTO dto, UriComponentsBuilder UriBuilder) {
        TaskDTO taskdto = taskService.creatTasks(dto);
        URI address = UriBuilder.path("/tasks/{id}").buildAndExpand(taskdto.getId()).toUri();
        return ResponseEntity.created(address).body(taskdto);
    }

    @GetMapping
    public ResponseEntity<Page<TaskDTO>> readTask(@PageableDefault(size = 10) Pageable page){
        Page<TaskDTO> pagesDTO = taskService.readAllTask(page);
        return ResponseEntity.ok(pagesDTO);
    }  

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable @Valid Long id, @RequestBody @Valid TaskDTO dto) {
        TaskDTO task = taskService.update(id,dto);
        return ResponseEntity.ok(task); 
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteTask(@Valid @PathVariable Long id){
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
