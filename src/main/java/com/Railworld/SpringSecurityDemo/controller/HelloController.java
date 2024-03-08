package com.Railworld.SpringSecurityDemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(HttpServletRequest request){
        System.out.println(request.getSession().getId());
        return "Hello World";
    }


}
