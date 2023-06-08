package com.example.j2ee.util;

import com.example.j2ee.entity.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BorrowReturn {
    public Book book;
    private String borrowTime;
    private String endTime;
    private String late;
}
