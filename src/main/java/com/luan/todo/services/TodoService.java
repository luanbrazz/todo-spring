package com.luan.todo.services;

import com.luan.todo.domain.Todo;
import com.luan.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public Todo findById(Integer id){
        Optional<Todo> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<Todo> findAllOpen() {
        List<Todo> list = repository.finAllOpen();
        return list;
    }

    public List<Todo> findAllClose() {
        List<Todo> list = repository.finAllClose();
        return list;
    }

    @GetMapping
    public List<Todo> findAll() {
        List<Todo> list = repository.findAll();
        return list;
    }

    public Todo create(Todo obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
