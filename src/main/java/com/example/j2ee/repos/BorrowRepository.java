package com.example.j2ee.repos;

import com.example.j2ee.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 借阅管理 jpa查询
 * @Date 2020/7/14 16:14
 * @Author by 尘心
 */
@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Integer>{
    List<Borrow> findBorrowByUserId(Integer userId);
    List<Borrow> findBorrowsByUserIdAndRet(@Param("userId") Integer userId,@Param("isReturn")Integer isReturn);
    Borrow findBorrowByUserIdAndBookId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);
}
