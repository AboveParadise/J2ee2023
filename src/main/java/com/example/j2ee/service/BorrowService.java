package com.example.j2ee.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.j2ee.dao.BorrowMapper;
import com.example.j2ee.entity.Book;
import com.example.j2ee.entity.Borrow;
import com.example.j2ee.entity.User;
import com.example.j2ee.repos.BorrowRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Transactional
    public Integer addBorrow(Borrow borrow) {
        Book book = bookService.findBook(borrow.getBookId());
        User users = userService.findUserById(borrow.getUserId());

        // 查询是否已经借阅过该图书
        Borrow bor = findBorrowByUserIdAndBookId(users.getId(),book.getId());
        if (bor!=null) {
            Integer ret = bor.getIsReturn();
            if (ret!=null) {
                // 已借阅, 未归还 不可再借
                if (ret == 0) {
                    return -1;
                }
            }
        }

        // 库存数量减一
        int size = book.getNumber();
        if (size>0) {
            size--;
            book.setNumber(size);
            bookService.updateBook(book);
        }else {
            return -2;
        }

        // 用户可借数量减一
        int userSize = users.getBalance();
        if (userSize>0) {
            userSize --;
            users.setBalance(userSize);
            userService.updateUser(users);
        }else {
            return -3;
        }


        // 添加借阅信息, 借阅默认为未归还状态
        borrow.setIsReturn(0);
        borrowRepository.saveAndFlush(borrow);

        // 一切正常
        return 0;
    }

    /**
     * user id查询所有借阅信息
     */
    public List<Borrow> findAllBorrowByUserId(Integer userId) {
        return borrowRepository.findBorrowByUserId(userId);
    }

    /**
     * user id查询所有 已借阅信息
     */
    public List<Borrow> findBorrowsByUserIdAndRet(Integer userId, Integer ret) {
        return borrowRepository.findBorrowsByUserIdAndRet(userId,ret);
    }


    /**
     * 详情
     */
    public Borrow findById(Integer id) {
        Optional<Borrow> optional = borrowRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * 编辑
     */
    public boolean updateBorrow(Borrow borrow) {
        return borrowMapper.updateBorrow(borrow)>0;
    }


    /**
     * 编辑
     */
    public Borrow updateBorrowByRepo(Borrow borrow) {
        return borrowRepository.saveAndFlush(borrow);
    }

    /**
     * s删除
     */
    public void deleteBorrow(Integer id) {
        borrowRepository.deleteById(id);
    }

    /**
     * 查询用户某一条借阅信息
     * @param userId 用户id
     * @param bookId 图书id
     */
    public Borrow findBorrowByUserIdAndBookId(int userId,int bookId) {
        return borrowMapper.findBorrowByUserIdAndBookId(userId,bookId);
    }

    /**
     * 归还书籍, 使用事务保证 ACID
     * @param userId 用户Id
     * @param bookId 书籍id
     */
    @Transactional(rollbackFor = Exception.class)
    public void retBook(int userId,int bookId) {
        // 用户可借数量加1
        User user = userService.findUserById(userId);
        Integer size = user.getBalance();
        size++;
        user.setBalance(size);
        userService.updateUser(user);


        // 书籍库存加1
        Book book = bookService.findBook(bookId);
        Integer bookSize = book.getNumber();
        bookSize++;
        book.setNumber(bookSize);
        bookService.updateBook(book);
        // 借阅记录改为已归还,删除记录
        Borrow borrow = this.findBorrowByUserIdAndBookId(userId, bookId);
//        borrow.setRet(Constants.YES);
//        borrow.setUpdateTime(new Date());
//        borrowMapper.updateBor(BeanUtil.beanToMap(borrow))>0;
        this.deleteBorrow(borrow.getId());
    }
}
