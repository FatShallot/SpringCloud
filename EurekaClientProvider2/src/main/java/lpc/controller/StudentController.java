package lpc.controller;

import lpc.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class StudentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"张三"));
        list.add(new Student(2,"李四"));
        return list;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return new Student(id,"蓝染");
    }

    @GetMapping("/port")
    public String getPost() {
        return port;
    }
}
