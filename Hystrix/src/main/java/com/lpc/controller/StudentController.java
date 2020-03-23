package com.lpc.controller;

import com.lpc.entity.Student;
import com.lpc.service.StudentFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hystrix")
public class StudentController {
    private StudentFeignClient studentFeignClient;

    @Autowired
    public StudentController(StudentFeignClient studentFeignClient) {
        this.studentFeignClient = studentFeignClient;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentFeignClient.getStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return studentFeignClient.getStudentById(id);
    }

    @GetMapping("/port")
    public String getPort() {
        return studentFeignClient.getPort();
    }
}
