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
@RequestMapping("/ribbon")
public class StudentController {
    private RestTemplate restTemplate;

    @Autowired
    public StudentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //服务提供者的地址localhost:21000替换为了provider
    //因为这个地址直接去注册中心获取
    @GetMapping("/students")
    public List<Student> getStudents() {
        return restTemplate.getForObject("http://provider/provider/students", List.class);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return restTemplate.getForObject("http://provider/provider/student/{id}", Student.class, id);
    }

    @GetMapping("/port")
    public String getPort() {
        return restTemplate.getForObject("http://provider/provider/port", String.class);
    }

}
