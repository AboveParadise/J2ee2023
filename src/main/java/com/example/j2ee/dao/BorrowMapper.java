package com.example.j2ee.dao;

import com.example.j2ee.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Map;

@Mapper
@Component
public interface BorrowMapper {

    @Update("update borrow set user_id = #{userId},book_id = #{bookId},return_time = #{returnTime} where id = #{id}")
    int updateBorrow(Borrow borrow);

    @Select("select * from borrow where user_id = #{userId} and book_id = #{bookId}")
    Borrow findBorrowByUserIdAndBookId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    int updateBor(Map<String,Object> map);
}
