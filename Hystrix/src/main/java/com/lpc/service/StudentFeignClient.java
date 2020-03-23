package com.lpc.service;

import com.lpc.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "provider")
public interface StudentFeignClient {
    @GetMapping("/provider/students")
    public List<Student> getStudents();

    @GetMapping("/provider/student/{id}")
    public Student getStudentById(@PathVariable("id") int id);

    @GetMapping("/provider/port")
    public String getPort();
}
