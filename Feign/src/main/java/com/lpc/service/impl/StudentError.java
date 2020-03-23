package com.lpc.service.impl;

import com.lpc.entity.Student;
import com.lpc.service.StudentFeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

//记得要加@Component注解将这个类放到IoC容器中
@Component
public class StudentError implements StudentFeignClient {
    @Override
    public List<Student> getStudents() {
        return null;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public String getPort() {
        return "服务器维护中";
    }
}
