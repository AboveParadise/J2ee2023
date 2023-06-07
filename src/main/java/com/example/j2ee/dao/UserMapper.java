package com.example.j2ee.dao;

import com.example.j2ee.entity.Book;
import com.example.j2ee.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Mapper
@Component
public interface UserMapper {
    int updateUser(Map<String,Object> map);
    List<User> findUserByLike(String keyword);
}
