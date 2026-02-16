package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.service.ServiceImp;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private ServiceImp serviceImp;

    @Autowired
    public TodoController(ServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todos=serviceImp.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        return serviceImp.getTodoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Todo>> getCompletedTodos(){
        return ResponseEntity.ok(serviceImp.getCompletedTodos());
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Todo>> getPendingTodos(){
        return ResponseEntity.ok(serviceImp.getPendingTodos());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Todo>> searchTodos(@RequestParam String keyword){
        return ResponseEntity.ok(serviceImp.searchTodo(keyword));
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Long>> getStats(){
        Map<String, Long> stats=new HashMap<>();
        stats.put("total",serviceImp.getTotalCount());
        stats.put("completed",serviceImp.getCompletedCount());
        stats.put("Pending",serviceImp.getTotalCount()-serviceImp.getCompletedCount());
        return ResponseEntity.ok(stats);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestParam Todo todo){
        Todo created=serviceImp.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> updaateTodo(@PathVariable Long id,@RequestParam Todo todo){
        try{
            Todo updated =serviceImp.updateTodo(id, todo);
            return ResponseEntity.ok(updated);
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Todo> toggleTodoStatus(@PathVariable Long id){
        try{
            Todo updated=serviceImp.toggleTodoStatus(id);
            return ResponseEntity.ok(updated);
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
        serviceImp.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
