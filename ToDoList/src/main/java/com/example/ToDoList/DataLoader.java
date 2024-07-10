package com.example.ToDoList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(TaskRepository repository){
        return args -> {
            repository.save(new Task(1L, "Learn React", false));
            repository.save(new Task(2L, "Learn Golang", false));
            repository.save(new Task(3L, "Learn Java", true));
        };
    }
}