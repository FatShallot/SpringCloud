package com.lpc.controller;

import com.lpc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class StudentController {
    private RestTemplate restTemplate;

    @Autowired
    public StudentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 这样写那还不是严重耦合？
     */
    @GetMapping("/students")
    public List<Student> getStudents() {
        return restTemplate.getForObject("http://localhost:21000/provider/students", List.class);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return restTemplate.getForObject("http://localhost:21000/provider/student/{id}", Student.class, id);
    }

}
