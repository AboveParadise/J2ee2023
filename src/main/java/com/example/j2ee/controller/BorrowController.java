package com.example.j2ee.controller;

import cn.hutool.core.date.DateUtil;
import com.example.j2ee.entity.Borrow;
import com.example.j2ee.service.BookService;
import com.example.j2ee.service.BorrowService;
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


//    @ApiOperation("已借阅列表")
//    @GetMapping("/borrowed")
//    public Returner borrowedList(Integer userId) {
//        List<BackOut> outs = new ArrayList<>();
//        if (userId!=null&&userId>0) {
//            List<Borrow> borrows = borrowService.findBorrowsByUserIdAndRet(userId, Constants.NO);
//            for (Borrow borrow : borrows) {
//                BackOut backOut = new BackOut();
//                BookOut out = bookService.findBookById(borrow.getBookId());
//                BeanUtils.copyProperties(out,backOut);
//
//                backOut.setBorrowTime(DateUtil.format(borrow.getCreateTime(),Constants.DATE_FORMAT));
//
//                String endTimeStr = DateUtil.format(borrow.getEndTime(), Constants.DATE_FORMAT);
//                backOut.setEndTime(endTimeStr);
//                String toDay = DateUtil.format(new Date(), Constants.DATE_FORMAT);
//                int i = toDay.compareTo(endTimeStr);
//                if (i>0) {
//                    backOut.setLate(Constants.YES_STR);
//                }else {
//                    backOut.setLate(Constants.NO_STR);
//                }
//
//                outs.add(backOut);
//            }
//        }
//
//        return R.success(CodeEnum.SUCCESS,outs);
//    }

    @ApiOperation("归还书籍")
    @PostMapping("/ret")
    public Returner retBook(Integer userId, Integer bookId) {
        borrowService.retBook(userId,bookId);
        return new Returner(200);
    }

}
