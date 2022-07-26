package com.luan.todo.services;

import com.luan.todo.domain.Todo;
import com.luan.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TodoRepository todoRepository;

    public void instanciaBaseDeDados(){
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Todo t1 = new Todo(null, "Estudar", "Estudar java e angular", LocalDateTime.parse("25/03/2022 10:40", formatter), false);
        Todo t2 = new Todo(null, "Ler", "Ler um livro", LocalDateTime.parse("25/07/2022 10:40", formatter), true);
        Todo t3 = new Todo(null, "Correr", "Correr 20 km", LocalDateTime.parse("02/08/2022 10:40", formatter), false);
        Todo t4 = new Todo(null, "Organizar", "Organizar a cassa", LocalDateTime.parse("15/08/2022 10:40", formatter), false);

        todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
    }
}
