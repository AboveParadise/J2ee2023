package com.example.j2ee.dao;

import com.example.j2ee.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface BookMapper {
    List<Book> findBook(String keyword);
    int updateBook(Map<String, Object> map);
}
