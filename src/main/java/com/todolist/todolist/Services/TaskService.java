package com.todolist.todolist.Services;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.todolist.todolist.DTOS.TaskDTO;
import com.todolist.todolist.Entities.Task;
import com.todolist.todolist.Repositories.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public TaskDTO creatTasks(TaskDTO dto) {
        Task task = modelMapper.map(dto, Task.class);
        taskRepository.save(task);

        return modelMapper.map(task, TaskDTO.class);
    }

    public Page<TaskDTO> readAllTask(Pageable page) {
        return taskRepository.findAll(page).map(t -> modelMapper.map(t,TaskDTO.class));
    }

    public TaskDTO update(Long id, TaskDTO dto) {
        Task task = modelMapper.map(dto, Task.class);
        task.setId(id);
        task = taskRepository.save(task);
        return modelMapper.map(task,TaskDTO.class);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
    
}
