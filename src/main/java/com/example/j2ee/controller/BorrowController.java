package com.example.j2ee.controller;

import cn.hutool.core.date.DateUtil;
import com.example.j2ee.entity.Borrow;
import com.example.j2ee.service.BookService;
import com.example.j2ee.service.BorrowService;
import com.example.j2ee.util.BorrowReturn;
import com.example.j2ee.util.Returner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = "借阅管理")
@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BookService bookService;

    @ApiOperation("借阅列表")
    @GetMapping("/list")
    public Returner getBorrowList(Integer userId) {
        return new Returner(200,borrowService.findAllBorrowByUserId(userId));
    }

    @ApiOperation("借阅图书")
    @PostMapping("/add")
    public Returner addBorrow(@RequestBody Borrow borrow) {
        Integer result = borrowService.addBorrow(borrow);
        if (result == -1) {
            return new Returner(-1);
        }else if (result == -2) {
            return new Returner(-2);
        }else if (result == -3) {
            return new Returner(-3);
        }
        return new Returner(200,0);
    }

    @ApiOperation("编辑借阅")
    @PostMapping("/update")
    public Returner modifyBorrow(@RequestBody Borrow borrow) {
        return new Returner(200,borrowService.updateBorrow(borrow));
    }


    @ApiOperation("借阅详情")
    @GetMapping("/detail")
    public Returner borrowDetail(Integer id) {
        return new Returner(200,borrowService.findById(id));
    }

    @ApiOperation("删除归还记录")
    @GetMapping("/delete")
    public Returner delBorrow(Integer id) {
        borrowService.deleteBorrow(id);
        return new Returner(200);
    }


    @ApiOperation("已借阅列表")
    @GetMapping("/borrowed")
    public Returner borrowedList(Integer userId) {
        List<BorrowReturn> res = new ArrayList<>();
        List<Borrow> borrows = borrowService.findBorrowsByUserIdAndIsReturn(userId, 0);
        for (Borrow borrow : borrows) {
            BorrowReturn backOut = new BorrowReturn();
            backOut.setBook(bookService.findBookById(borrow.getBookId()));

            backOut.setBorrowTime(DateUtil.format(borrow.getBorrowTime(),"yyyy-MM-dd"));

            String endTimeStr = DateUtil.format(borrow.getEndTime(), "yyyy-MM-dd");
            backOut.setEndTime(endTimeStr);
            String toDay = DateUtil.format(new Date(), "yyyy-MM-dd");
            int i = toDay.compareTo(endTimeStr);
            if (i>0) {
                backOut.setLate("已逾期");
            }else {
                backOut.setLate("未逾期");
            }
            res.add(backOut);
        }
        return new Returner(200, res);
    }

    @ApiOperation("归还书籍")
    @PostMapping("/ret")
    public Returner retBook(Integer userId, Integer bookId) {
        borrowService.retBook(userId,bookId);
        return new Returner(200);
    }

}
