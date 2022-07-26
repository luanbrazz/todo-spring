package com.luan.todo;

import com.luan.todo.domain.Todo;
import com.luan.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Todo t1 = new Todo(null, "Estudar", "Estudar java e angular", LocalDateTime.parse("25/03/2022 10:40", formatter), false);
		Todo t2 = new Todo(null, "Ler", "Ler um livro", LocalDateTime.parse("25/07/2022 10:40", formatter), true);
		Todo t3 = new Todo(null, "Correr", "Correr 20 km", LocalDateTime.parse("02/08/2022 10:40", formatter), false);
		Todo t4 = new Todo(null, "Organizar", "Organizar a cassa", LocalDateTime.parse("15/08/2022 10:40", formatter), false);

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
