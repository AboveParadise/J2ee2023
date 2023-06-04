package com.example.j2ee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
    @GetMapping({"/login","/","logout"})
    public String toLogin() {
        return "login";
    }
    @RequestMapping({"/index"})
    public String toIndex() {
        return "index";
    }

    @RequestMapping({"/register"})
    public String toResgister() {
        return "register";
    }

    @RequestMapping("/{filename}/{name}")
    public String change(@PathVariable String filename, @PathVariable String name){
        return filename+ '/' +name;

    }
}
