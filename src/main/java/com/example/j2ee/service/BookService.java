package com.example.j2ee.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.j2ee.dao.BookMapper;
import com.example.j2ee.entity.Book;
import com.example.j2ee.repos.BookRepository;
import com.example.j2ee.util.PageParam;
import com.example.j2ee.util.PageReturner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public PageReturner getBookList(PageParam pageIn) {
        List<Book> list = bookMapper.findBookListByLike(pageIn.getKeyword());
        PageReturner pageReturner = new PageReturner();
        List<Book> res = new ArrayList<>();
        int start = (pageIn.getCurrPage() - 1) * pageIn.getPageSize();
        int end = pageIn.getCurrPage() * pageIn.getPageSize();
        if (end > list.size()) {
            end = list.size();
        }
        res = list.subList(start, end);
        pageReturner.setList(res);
        pageReturner.setTotal(list.size());
        pageReturner.setCurrPage(pageIn.getCurrPage());
        pageReturner.setPageSize(pageIn.getPageSize());
        return pageReturner;
    }

    public Book addBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    public boolean updateBook(Book book) {
        return bookMapper.updateBook(BeanUtil.beanToMap(book)) > 0;
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

    public Book findBook(Integer id) {
        Optional<Book> optional = bookRepository.findById(id);
        return optional.orElse(null);
    }
}
