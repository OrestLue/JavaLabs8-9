package com.example.demo;

import com.example.demo.enums.BookType;
import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(final BookRepository bookRepository) {

		return (args) -> {
			bookRepository.save(new Book("Book", BookType.FUN));

			bookRepository.findAll().forEach(System.out::println);
		};
	}
}
