package com.example.j2ee.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.j2ee.dao.BookMapper;
import com.example.j2ee.entity.Book;
import com.example.j2ee.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public Book addBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    public boolean updateBook(Book book) {
        return bookMapper.updateBook(BeanUtil.beanToMap(book))>0;
    }

    public Book findBookById(Integer id) {
        Optional<Book> optional = bookRepository.findById(id);
        return optional.orElse(null);
    }

    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

}
