package com.example.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task>getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task>getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, Task task) {
        Optional<Task> existingTaskOpt = taskRepository.findById(id);
        if (existingTaskOpt.isPresent()) {
            Task existingTask = existingTaskOpt.get();
            existingTask.setTitle(task.getTitle());
            existingTask.setCompleted(task.isCompleted());
            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }


}
