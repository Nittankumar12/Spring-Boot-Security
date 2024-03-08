package com.Railworld.SpringSecurityDemo.controller;

import com.Railworld.SpringSecurityDemo.model.Student;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentControlller {


    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Nittan","Java"),
            new Student(2,"Harsh","C++")
    ));


//    @GetMapping("csrf-token")
//    public CsrfToken getCsrfToken(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//    }


    @GetMapping("/students")
    public List<Student> getStudents(HttpServletRequest request){
        System.out.println(request.getSession().getId());
        return students;
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }
}
