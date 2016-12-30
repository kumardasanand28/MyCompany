package main.com.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import main.com.entity.Book;


public interface BookRepository extends JpaRepository<Book,Long> {

}
