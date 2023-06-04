package com.example.j2ee.util;

import java.io.Serializable;

public class Returner implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Returner(Integer code) {
        this.code = code;
    }

    public Returner(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
    public Returner(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Returner(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
