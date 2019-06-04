package com.example.demo.repositories;

import com.example.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

//@Transactional
//public interface BookRepository extends StuffRepository<Book>{
//
//}


public interface BookRepository extends CrudRepository<Book, Integer> {

}