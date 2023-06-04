package com.example.j2ee.util;

import lombok.Data;

@Data
public class PageReturner {
    private Integer currPage;

    private Integer pageSize;

    private Integer total;

    private Object list;
}
