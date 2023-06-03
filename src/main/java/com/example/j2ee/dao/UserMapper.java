package com.example.j2ee.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;
@Mapper
@Component
public interface UserMapper {
    int update_user(Map<String, Object> map);
}
