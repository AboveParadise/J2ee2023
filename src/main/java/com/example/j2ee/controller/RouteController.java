package com.example.j2ee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
    @RequestMapping({"/index"})
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/{filename}/{name}")
    public String change(@PathVariable String filename, @PathVariable String name){
        return filename+ '/' +name;

    }
}
