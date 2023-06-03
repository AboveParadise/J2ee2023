package com.example.j2ee.util;

import lombok.Data;

@Data
public class PageParam {
    private String keyword;

    private Integer currPage;

    private Integer pageSize;
}
