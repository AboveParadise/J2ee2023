package com.example.j2ee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.j2ee.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByIsbn(String isbn);
}
