package com.example.demo.service;


import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImp{

    private TodoRepository todoRepository;

    @Autowired
    public ServiceImp(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id){
        return todoRepository.findById(id);
    }

    public List<Todo> getCompletedTodos(){
        return todoRepository.findByCompleted(true);
    }

    public List<Todo> getPendingTodos(){
        return todoRepository.findByCompleted(false);
    }

    public List<Todo> searchTodo(String keyword){
        return todoRepository.findByTitleContaining(keyword);
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo updateTodo(long id, Todo todoDetails){
        Todo todo=todoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Todo not found"));

        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setCompleted(todoDetails.isCompleted());

        return todoRepository.save(todo);
    }

    public Todo toggleTodoStatus(Long id){
        Todo todo=todoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Todo not Found"));

        todo.setCompleted(!todo.isCompleted());
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    public long getTotalCount(){
        return todoRepository.count();
    }

    public long getCompletedCount(){
        return todoRepository.countByCompleted(true);
    }

}
