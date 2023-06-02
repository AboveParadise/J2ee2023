package com.example.j2ee.controller;

import com.example.j2ee.entity.Book;
import com.example.j2ee.service.BookService;
import com.example.j2ee.util.Returner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Returner addBook(@RequestBody Book book) {
        return new Returner(200, bookService.addBook(book));
    }

    @PostMapping("/update")
    public Returner modifyBook(@RequestBody Book book) {
        return new Returner(200,bookService.updateBook(book));
    }

    @GetMapping("/detail")
    public Returner bookDetail(Integer id) {
        return new Returner(200,bookService.findBookById(id));
    }

    @GetMapping("/detailByIsbn")
    public Returner bookDetailByIsbn(String isbn) {
        return new Returner(200,bookService.findBookByIsbn(isbn));
    }

    @GetMapping("/delete")
    public Returner delBook(Integer id) {
        bookService.deleteBook(id);
        return new Returner(200);
    }
}
